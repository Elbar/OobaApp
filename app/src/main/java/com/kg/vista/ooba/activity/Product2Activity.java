package com.kg.vista.ooba.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Product2;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kg.vista.ooba.api.conf.Config.BASE_URL;


public class Product2Activity extends AbstractActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getProducts();

    }

    private void getProducts() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);

        Call<Product2> getExecutorProfile = request.getProductByIndex();

        getExecutorProfile.enqueue(new Callback<Product2>() {
            @Override
            public void onResponse(Call<Product2> call, Response<Product2> response) {


            }

            @Override
            public void onFailure(Call<Product2> call, Throwable t) {

            }
        });

    }

}
