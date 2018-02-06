package com.kg.vista.ooba.ui.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.kg.vista.ooba.ui.fragment.CatalogFragment;

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

public class MainActivity extends AbstractActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
    private NavigationView navigationView;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private UsersManagement usrData;
    private List<Groupon> grouponList;
    private List<Collection> collectionList;
    private List<Brand> brandList;
    private List<Store> shopList;
    private CircleIndicator grouponCircleIndicator;
    private GrouponViewPagerAdapter grouponViewPagerAdapter;
    private ViewPager grouponViewPager;
    private BestCollectionRecyclerViewAdapter bestCollectionRVAdapter;
    private WhatsNewGVAdapter whatsNewRVAdapter;
    private CircleIndicator bestCollectionCircleIndicator;
    private BrandAdapter brandAdapter;
    private GridView brandGridView;
    private CircleIndicator brandCircleIndicator;
    private ShopAdapter shopGridViewAdapter;
    private GridView shopGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


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
                getWhatsNewItems();


            }
        });
        mShowPopularItemsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWhatsPopularItems();


            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayShowTitleEnabled(false);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        final LinearLayoutManager whatsNewLinearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        grouponViewPager = (ViewPager) findViewById(R.id.grouponViewPager);
//        grouponCircleIndicator = (CircleIndicator) findViewById(R.id.groupon_circle_indicator);
        bestCollectionCircleIndicator = (CircleIndicator) findViewById(R.id.best_collection_circle_indicator);

        brandGridView = (GridView) findViewById(R.id.brand_gv);
//        brandCircleIndicator = (CircleIndicator) findViewById(R.id.brand_circle_indicator);
        shopGridView = (GridView) findViewById(R.id.grid_view_shop);
        brandGridView.setVerticalScrollBarEnabled(false);


        setUIFromAdapters();

    }


    private void getWhatsNewItems() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);


        Call<List<WhatsNew>> getUserNotifications = request.getWhatsNewItems();

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

                    WhatsNewGVAdapter adapter = new WhatsNewGVAdapter(MainActivity.this, whatsNewItem);
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

                    WhatsNewGVAdapter adapter = new WhatsNewGVAdapter(MainActivity.this, whatsNewItem);
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

                    WhatsNewGVAdapter adapter = new WhatsNewGVAdapter(MainActivity.this, whatsNewItem);
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

                    WhatsNewGVAdapter adapter = new WhatsNewGVAdapter(MainActivity.this, whatsNewItem);
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
                LinearLayoutManager bestCollectionLinearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

                int randomNumber = new Random().nextInt(grouponList.size()) + 1;
                grouponViewPagerAdapter = new GrouponViewPagerAdapter(MainActivity.this, grouponList);
                grouponViewPager.setAdapter(grouponViewPagerAdapter);
                grouponViewPager.setCurrentItem(randomNumber);
//                grouponCircleIndicator.setViewPager(grouponViewPager);


                int randomNumber1 = new Random().nextInt(collectionList.size()) + 1;

                bestCollectionRVAdapter = new BestCollectionRecyclerViewAdapter(collectionList);
                mBestCollectionRV.setLayoutManager(bestCollectionLinearLayoutManager);
                mBestCollectionRV.setAdapter(bestCollectionRVAdapter);


//                bestCollectionViewPager.setCurrentItem(randomNumber1);
//                bestCollectionCircleIndicator.setViewPager(bestCollectionViewPager);
//
                int randomNumber2 = new Random().nextInt(brandList.size()) + 1;
                brandAdapter = new BrandAdapter(MainActivity.this, brandList);
                brandGridView.setAdapter(brandAdapter);
//                brandGridView.setCurrentItem(randomNumber2);
//                brandCircleIndicator.setViewPager(brandGridView);

                final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
                layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
                shopGridViewAdapter = new ShopAdapter(MainActivity.this, shopList);
//                shopGridView.setLayoutManager(layoutManager);
//                shopGridView.setHasFixedSize(true);
                shopGridView.setAdapter(shopGridViewAdapter);
//                shopGridView.addOnScrollListener(new CenterScrollListener());

            }

            @Override
            public void onFailure(Call<MainRequest> call, Throwable t) {

            }
        });
    }

    protected void onResume() {
        super.onResume();
        usrData = new UsersManagement();
        String USER_ID = usrData.getUserData(this);
        Log.d("user_id", "id " + USER_ID);
        if (Integer.parseInt(USER_ID) == 0) {
            setItemVisibility(false, View.INVISIBLE);
        } else {
            setItemVisibility(true, View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setItemVisibility(boolean visible, int visibility) {
        Menu nav_Menu = navigationView.getMenu();
//        nav_Menu.findItem(R.id.sub_item).setVisible(visible);

        View header = navigationView.getHeaderView(0);
        header.setVisibility(visibility);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        UsersManagement usrData = new UsersManagement();
        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_basket) {
            // if user logged in start ShopActivity otherwise start LoginActivity
//            Intent intent;
//            String USER_ID = usrData.getUserData(this);
//            if (Integer.parseInt(USER_ID) > 0) {
//                //start activity shop
//                Log.d("my_id", "id = "+USER_ID);
//                intent = new Intent(this, ShopActivity.class);
//            } else {
//                //start activity login
//                intent = new Intent(this, LoginActivity.class);
//            }
//            startActivity(intent);
        } else if (id == R.id.menu_notification) {
            //start activity notifications
//            Intent intent = new Intent(this, NotificationActivity.class);
//            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        switch (id) {
            case R.id.nav_lenta:
                break;
            case R.id.nav_catalog:
                CatalogFragment catalogFragment = new CatalogFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, catalogFragment)
                        .addToBackStack(null)
                        .commit();
//                Intent catalogIntent = new Intent(MainActivity.this, CatalogActivity.class);
//                startActivity(catalogIntent);
            case R.id.nav_collections:
                break;

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
