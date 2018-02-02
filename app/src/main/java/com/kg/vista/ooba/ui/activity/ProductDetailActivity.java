package com.kg.vista.ooba.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Product2;
import com.kg.vista.ooba.model.ProductDetail;
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


public class ProductDetailActivity extends AbstractActivity {

    private String TAG = "ProductDetailActivity";
    @BindView(R.id.add_to_cart_btn)
    Button mAddToCartBtn;
    @BindView(R.id.product_price_tv)
    TextView mProductPriceTV;
    @BindView(R.id.product_desc_tv)
    TextView mProductDescTV;
    @BindView(R.id.vendor_code_tv)
    TextView mVendorCodeTV;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String urlProduct = intent.getStringExtra("product_url");
        Toast.makeText(this, urlProduct, Toast.LENGTH_SHORT).show();

        getDetailOfProduct(urlProduct);

        mAddToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetailActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getDetailOfProduct(String urlProduct) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);

        Call<ProductDetail> getExecutorProfile = request.getDetailOfProduct(urlProduct);

        getExecutorProfile.enqueue(new Callback<ProductDetail>() {
            @Override
            public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {
                try {
                    ProductDetail product = response.body();
                    String detail = product.getDetailUrlTitle();
                    String goodID = product.getGoodsId();
                    String price = String.valueOf(product.getPrice());


                    mProductDescTV.setText(detail);
                    mVendorCodeTV.setText(goodID);
                    mProductPriceTV.setText(price+ " сом");

                    List<ProductDetail> productItem = new ArrayList<>();

//                    for (int i = 0; i < product.size(); i++) {
//                        Product2 product2 = new Product2();
//
//
//                    }

//                    mAdapter.setItems(productItem);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ProductDetail> call, Throwable t) {

            }
        });

    }

}
