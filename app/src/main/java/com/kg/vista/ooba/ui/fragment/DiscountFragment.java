package com.kg.vista.ooba.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.DiscountAdapter;
import com.kg.vista.ooba.adapter.GrouponViewPagerAdapter;
import com.kg.vista.ooba.model.Category;
import com.kg.vista.ooba.model.Groupon;
import com.kg.vista.ooba.model.MainRequest;
import com.kg.vista.ooba.ui.activity.App;
import com.kg.vista.ooba.ui.activity.ShopInDetailActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscountFragment extends Fragment {
    @BindView(R.id.grouponViewPager)
    ViewPager mGrouponVP;
    @BindView(R.id.discount_rv)
    RecyclerView mDiscountRV;
    private DiscountAdapter discountAdapter;


    private List<Groupon> grouponList;
    private GrouponViewPagerAdapter grouponViewPagerAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.discount_fragment, container, false);
        ButterKnife.bind(this, view);

        setUIFromAdapters();

        return view;
    }






    private void setUIFromAdapters() {
        App.api().mainRequest().enqueue(new Callback<MainRequest>() {
            @Override
            public void onResponse(Call<MainRequest> call, Response<MainRequest> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                grouponList = response.body().getGroupon();
                LinearLayoutManager bestCollectionLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

                int randomNumber = new Random().nextInt(grouponList.size()) + 1;
                grouponViewPagerAdapter = new GrouponViewPagerAdapter(getContext(), grouponList);
                mGrouponVP.setAdapter(grouponViewPagerAdapter);
                mGrouponVP.setCurrentItem(randomNumber);
//                grouponCircleIndicator.setViewPager(grouponViewPager);



            }

            @Override
            public void onFailure(Call<MainRequest> call, Throwable t) {

            }
        });
    }


    public void getCategories(final String indexShop) {


        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("http://api.ooba.kg/?url=catalog/" + indexShop)
                .get()
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, final okhttp3.Response response) throws IOException {
                final String json = response.body().string();

                        try {
                            JSONObject menu = new JSONObject(json);
                            JSONArray category = menu.getJSONArray("category");

                            List<Category> categories = new ArrayList<>();

                            for (int i = 0; i < category.length(); i++) {
                                JSONObject cat = category.getJSONObject(i);
                                Category category1 = new Category();
                                category1.setCatId(cat.getString("cat_id"));
                                category1.setCatName(cat.getString("cat_name"));
                                categories.add(category1);

                            }

                            discountAdapter = new DiscountAdapter(getContext(), categories);

                            mDiscountRV.setLayoutManager(new GridLayoutManager(getContext(), 2));

                            mDiscountRV.setAdapter(discountAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



            }
        });
    }



}
