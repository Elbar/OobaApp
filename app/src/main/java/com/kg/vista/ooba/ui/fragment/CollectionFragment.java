package com.kg.vista.ooba.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.CollectionRVAdapter;
import com.kg.vista.ooba.adapter.DiscountRVAdapter;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Collection;
import com.kg.vista.ooba.model.CollectionGood;
import com.kg.vista.ooba.model.Discount;

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


public class CollectionFragment extends Fragment {
    @BindView(R.id.collection_rv)
    RecyclerView mCollectionRV;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection_fragment, container, false);
        ButterKnife.bind(this, view);
        getCollectionGoods();

        return view;
    }



    private void getCollectionGoods() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);


        Call<List<CollectionGood>> discountCall = request.getCollectionGoods();

        discountCall.enqueue(new Callback<List<CollectionGood>>() {
            @Override
            public void onResponse(@NonNull Call<List<CollectionGood>> call, @NonNull Response<List<CollectionGood>> response) {

                try {
                    List<CollectionGood> collectionGoods = response.body();
                    List<CollectionGood> collectionItem = new ArrayList<>();

                    for (int i = 0; i < collectionGoods.size(); i++) {

                        CollectionGood collectionGood = new CollectionGood();
                        collectionGood.setTitle(collectionGoods.get(i).getTitle());
                        collectionGood.setInfo(collectionGoods.get(i).getInfo());
                        collectionGood.setPicUrl(collectionGoods.get(i).getPicUrl());
                        collectionItem.add(collectionGood);

                    }


                    mCollectionRV.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    mCollectionRV.setLayoutManager(layoutManager);
                    CollectionRVAdapter adapter = new CollectionRVAdapter(getActivity(), collectionItem);
                    mCollectionRV.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


            @Override
            public void onFailure(Call<List<CollectionGood>> call, Throwable t) {

            }
        });

    }






}
