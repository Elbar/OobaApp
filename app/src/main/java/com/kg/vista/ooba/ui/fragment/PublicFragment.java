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
import com.kg.vista.ooba.adapter.DiscountRVAdapter;
import com.kg.vista.ooba.adapter.PublicRVAdapter;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Discount;
import com.kg.vista.ooba.model.PublicGood;

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


public class PublicFragment extends Fragment {
    @BindView(R.id.public_rv)
    RecyclerView mPublicRV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.public_fragment, container, false);
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


        Call<List<PublicGood>> discountCall = request.getPublicGoods();

        discountCall.enqueue(new Callback<List<PublicGood>>() {
            @Override
            public void onResponse(@NonNull Call<List<PublicGood>> call, @NonNull Response<List<PublicGood>> response) {

                try {
                    List<PublicGood> publicGoods = response.body();
                    List<PublicGood> publicItem = new ArrayList<>();

                    for (int i = 0; i < publicGoods.size(); i++) {

                        PublicGood publicGood = new PublicGood();
                        publicGood.setTitle(publicGoods.get(i).getTitle());
                        publicGood.setViews(publicGoods.get(i).getViews());
                        publicGood.setAgotime(publicGoods.get(i).getAgotime());
                        publicGood.setDescription(publicGoods.get(i).getDescription());
                        publicGood.setFileUrl(publicGoods.get(i).getFileUrl());
                        publicItem.add(publicGood);

                    }


                    mPublicRV.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    mPublicRV.setLayoutManager(layoutManager);
                    PublicRVAdapter adapter = new PublicRVAdapter(getActivity(), publicItem);
                    mPublicRV.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


            @Override
            public void onFailure(Call<List<PublicGood>> call, Throwable t) {

            }
        });

    }


}
