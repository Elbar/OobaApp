package com.kg.vista.ooba.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.DiscountRVAdapter;
import com.kg.vista.ooba.adapter.GrouponViewPagerAdapter;
import com.kg.vista.ooba.adapter.ProductRVAdapter;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Discount;
import com.kg.vista.ooba.model.Groupon;

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

public class DiscountFragment extends Fragment {
    @BindView(R.id.discount_rv)
    RecyclerView mDiscountRV;

    private DiscountRVAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.discount_fragment, container, false);
        ButterKnife.bind(this, view);

        getDiscountGoods();

        return view;
    }



    private void getDiscountGoods() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);


        Call<List<Discount>> discountCall = request.getDiscountGoods();

        discountCall.enqueue(new Callback<List<Discount>>() {
            @Override
            public void onResponse(@NonNull Call<List<Discount>> call, @NonNull Response<List<Discount>> response) {

                try {
                    List<Discount> discounts = response.body();
                    List<Discount> discountItem = new ArrayList<>();

                    for (int i = 0; i < discounts.size(); i++) {

                        Discount discount = new Discount();
                        discount.setGoodsName(discounts.get(i).getGoodsName());
                        discount.setPrice(discounts.get(i).getPrice());
                        discount.setPriceTotal(discounts.get(i).getPriceTotal());
                        discount.setCnt(discounts.get(i).getCnt());
                        discount.setPicUrl(discounts.get(i).getPicUrl());
                        discountItem.add(discount);

                    }


                    mDiscountRV.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    mDiscountRV.setLayoutManager(layoutManager);
                    DiscountRVAdapter adapter = new DiscountRVAdapter(getActivity(), discountItem);
                    mDiscountRV.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


            @Override
            public void onFailure(Call<List<Discount>> call, Throwable t) {

            }
        });

    }




}
