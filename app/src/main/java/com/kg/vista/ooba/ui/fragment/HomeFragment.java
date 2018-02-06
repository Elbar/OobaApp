package com.kg.vista.ooba.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.BestCollectionRecyclerViewAdapter;
import com.kg.vista.ooba.adapter.BrandAdapter;
import com.kg.vista.ooba.adapter.GrouponViewPagerAdapter;
import com.kg.vista.ooba.adapter.ShopAdapter;
import com.kg.vista.ooba.adapter.WhatsNewGVAdapter;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Brand;
import com.kg.vista.ooba.model.Collection;
import com.kg.vista.ooba.model.Groupon;
import com.kg.vista.ooba.model.MainRequest;
import com.kg.vista.ooba.model.Store;
import com.kg.vista.ooba.model.WhatsNew;
import com.kg.vista.ooba.ui.activity.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kg.vista.ooba.api.conf.Config.BASE_URL;

public class HomeFragment extends Fragment {

    @BindView(R.id.best_collection_rv)
    RecyclerView mBestCollectionRV;
    @BindView(R.id.whats_new_gv)
    GridView mWhatsNewGV;
    @BindView(R.id.show_all_items_cv)
    CardView mShowAllItemsCV;
    @BindView(R.id.show_blogs_cv)
    CardView mShowBlogsCV;
    @BindView(R.id.show_popular_items_cv)
    CardView mShowPopularItemsCV;
    @BindView(R.id.show_new_items_cv)
    CardView mShowNewItemsCV;
    @BindView(R.id.grouponViewPager)
    ViewPager mGrouponVP;
    @BindView(R.id.brand_gv)
    GridView mBrandGV;
    @BindView(R.id.grid_view_shop)
    GridView mShopGV;
    private List<Groupon> grouponList;
    private List<Collection> collectionList;
    private List<Brand> brandList;
    private List<Store> shopList;
    private CircleIndicator grouponCircleIndicator;
    private GrouponViewPagerAdapter grouponViewPagerAdapter;
    private BestCollectionRecyclerViewAdapter bestCollectionRVAdapter;
    private WhatsNewGVAdapter whatsNewRVAdapter;
    private CircleIndicator bestCollectionCircleIndicator;
    private BrandAdapter brandAdapter;
    private GridView brandGridView;
    private CircleIndicator brandCircleIndicator;
    private ShopAdapter shopGridViewAdapter;
    private GridView shopGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);

        getWhatsAllItems();
        mShowAllItemsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWhatsAllItems();


            }
        });

        mShowBlogsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBlogs();


            }
        });
        mShowNewItemsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getWhatsNewItems();


            }
        });
        mShowPopularItemsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWhatsPopularItems();


            }
        });


        final LinearLayoutManager whatsNewLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mBrandGV.setVerticalScrollBarEnabled(false);

        setUIFromAdapters();

        return view;
    }


    private void getWhatsAllItems() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);


        Call<List<WhatsNew>> getUserNotifications = request.getWhatsAllItems();

        getUserNotifications.enqueue(new Callback<List<WhatsNew>>() {
            @Override
            public void onResponse(@NonNull Call<List<WhatsNew>> call, @NonNull Response<List<WhatsNew>> response) {

                try {
                    List<WhatsNew> whatsNews = response.body();
                    List<WhatsNew> whatsNewItem = new ArrayList<>();

                    for (int i = 0; i < whatsNews.size(); i++) {
                        WhatsNew whatsNew = new WhatsNew();
                        whatsNew.setTitle(whatsNews.get(i).getTitle());
                        whatsNew.setFileUrl("http://ooba.kg/" + whatsNews.get(i).getFileUrl());
                        whatsNewItem.add(whatsNew);

                    }

//                    whatsNewRVAdapter = new WhatsNewGVAdapter(whatsNewItem);
//                    mWhatsNewRV.setLayoutManager(whatsNewLinearLayoutManager);
//                    mWhatsNewRV.setAdapter(whatsNewRVAdapter);

                    WhatsNewGVAdapter adapter = new WhatsNewGVAdapter(getContext(), whatsNewItem);
                    mWhatsNewGV.setAdapter(adapter);


                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


            @Override
            public void onFailure(Call<List<WhatsNew>> call, Throwable t) {

            }
        });

    }

    private void getWhatsPopularItems() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);


        Call<List<WhatsNew>> getUserNotifications = request.getWhatsPopularItems();

        getUserNotifications.enqueue(new Callback<List<WhatsNew>>() {
            @Override
            public void onResponse(@NonNull Call<List<WhatsNew>> call, @NonNull Response<List<WhatsNew>> response) {

                try {
                    List<WhatsNew> whatsNews = response.body();
                    List<WhatsNew> whatsNewItem = new ArrayList<>();

                    for (int i = 0; i < whatsNews.size(); i++) {
                        WhatsNew whatsNew = new WhatsNew();
                        whatsNew.setTitle(whatsNews.get(i).getTitle());
                        whatsNew.setFileUrl("http://ooba.kg/" + whatsNews.get(i).getFileUrl());
                        whatsNewItem.add(whatsNew);

                    }

//                    whatsNewRVAdapter = new WhatsNewGVAdapter(whatsNewItem);
//                    mWhatsNewRV.setLayoutManager(whatsNewLinearLayoutManager);
//                    mWhatsNewRV.setAdapter(whatsNewRVAdapter);

                    WhatsNewGVAdapter adapter = new WhatsNewGVAdapter(getContext(), whatsNewItem);
                    mWhatsNewGV.setAdapter(adapter);


                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


            @Override
            public void onFailure(Call<List<WhatsNew>> call, Throwable t) {

            }
        });

    }

    private void getBlogs() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);


        Call<List<WhatsNew>> getUserNotifications = request.getBlogs();

        getUserNotifications.enqueue(new Callback<List<WhatsNew>>() {
            @Override
            public void onResponse(@NonNull Call<List<WhatsNew>> call, @NonNull Response<List<WhatsNew>> response) {

                try {
                    List<WhatsNew> whatsNews = response.body();
                    List<WhatsNew> whatsNewItem = new ArrayList<>();

                    for (int i = 0; i < whatsNews.size(); i++) {
                        WhatsNew whatsNew = new WhatsNew();
                        whatsNew.setTitle(whatsNews.get(i).getTitle());
                        whatsNew.setFileUrl("http://ooba.kg/" + whatsNews.get(i).getFileUrl());
                        whatsNewItem.add(whatsNew);

                    }

//                    whatsNewRVAdapter = new WhatsNewGVAdapter(whatsNewItem);
//                    mWhatsNewRV.setLayoutManager(whatsNewLinearLayoutManager);
//                    mWhatsNewRV.setAdapter(whatsNewRVAdapter);

                    WhatsNewGVAdapter adapter = new WhatsNewGVAdapter(getContext(), whatsNewItem);
                    mWhatsNewGV.setAdapter(adapter);


                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


            @Override
            public void onFailure(Call<List<WhatsNew>> call, Throwable t) {

            }
        });

    }


    private void setUIFromAdapters() {
        App.api().mainRequest().enqueue(new Callback<MainRequest>() {
            @Override
            public void onResponse(Call<MainRequest> call, Response<MainRequest> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                grouponList = response.body().getGroupon();
                collectionList = response.body().getCollection();
                brandList = response.body().getBrand();
                shopList = response.body().getStore();
                LinearLayoutManager bestCollectionLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

                int randomNumber = new Random().nextInt(grouponList.size()) + 1;
                grouponViewPagerAdapter = new GrouponViewPagerAdapter(getContext(), grouponList);
                mGrouponVP.setAdapter(grouponViewPagerAdapter);
                mGrouponVP.setCurrentItem(randomNumber);
//                grouponCircleIndicator.setViewPager(grouponViewPager);


                int randomNumber1 = new Random().nextInt(collectionList.size()) + 1;

                bestCollectionRVAdapter = new BestCollectionRecyclerViewAdapter(collectionList);
                mBestCollectionRV.setLayoutManager(bestCollectionLinearLayoutManager);
                mBestCollectionRV.setAdapter(bestCollectionRVAdapter);


//                bestCollectionViewPager.setCurrentItem(randomNumber1);
//                bestCollectionCircleIndicator.setViewPager(bestCollectionViewPager);
//
                int randomNumber2 = new Random().nextInt(brandList.size()) + 1;
                brandAdapter = new BrandAdapter(getContext(), brandList);
                mBrandGV.setAdapter(brandAdapter);
//                brandGridView.setCurrentItem(randomNumber2);
//                brandCircleIndicator.setViewPager(brandGridView);

                final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
                layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
                shopGridViewAdapter = new ShopAdapter(getContext(), shopList);
//                shopGridView.setLayoutManager(layoutManager);
//                shopGridView.setHasFixedSize(true);
                mShopGV.setAdapter(shopGridViewAdapter);
//                shopGridView.addOnScrollListener(new CenterScrollListener());

            }

            @Override
            public void onFailure(Call<MainRequest> call, Throwable t) {

            }
        });
    }


}
