package com.kg.vista.ooba.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Product2;
import com.kg.vista.ooba.model.ProductList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kg.vista.ooba.api.conf.Config.BASE_URL;


public class ProductDetailActivity extends AbstractActivity {

    private String TAG = "ProductDetailActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
    }


    private void getProducts() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);

        Call<ProductList> getExecutorProfile = request.getProductByIndex();

        getExecutorProfile.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                try {
                    List<Product2> product = response.body().getProduct();

                    List<Product2> productItem = new ArrayList<>();

                    for (int i = 0; i < product.size(); i++) {
                        Log.e(TAG, product.get(i).getImages());
                        Product2 product2 = new Product2();

                        product2.setImages(product.get(i).getImages());
                        product2.setPrice(product.get(i).getPrice());
                        product2.setNickTitle(product.get(i).getNickTitle());
                        productItem.add(product2);

                    }

//                    mAdapter.setItems(productItem);

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
