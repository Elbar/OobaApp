package com.kg.vista.ooba.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.ProductRVAdapter;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Product2;
import com.kg.vista.ooba.model.ProductList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kg.vista.ooba.api.conf.Config.BASE_URL;


public class ProductActivity extends AbstractActivity {
    @BindView(R.id.product_rv)
    RecyclerView mProductRV;
    private String TAG = "ProductActivity";
    ProductRVAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String productUrl = intent.getStringExtra("url");

        getProducts(productUrl);

    }


    private void getProducts(final String productUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);

        Call<ProductList> getExecutorProfile = request.getProductByIndex(productUrl);

        getExecutorProfile.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                try {
                    List<Product2> product = response.body().getProduct();
                    List<Product2> productItem = new ArrayList<>();
                    Log.e("size", String.valueOf(product.size()));

                    for (int i = 0; i < product.size(); i++) {
                        Product2 product2 = new Product2();
                        product2.setImages(product.get(i).getImages());
                        product2.setPrice(product.get(i).getPrice());
                        product2.setNickTitle(product.get(i).getNickTitle());
                        product2.setUrlProduct(product.get(i).getUrlProduct());
                        productItem.add(product2);
                    }

                    mAdapter = new ProductRVAdapter(ProductActivity.this, productItem);

                    mProductRV.setLayoutManager(new GridLayoutManager(ProductActivity.this, 1));

                    mProductRV.setAdapter(mAdapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {

            }
        });

    }

}
