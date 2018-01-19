package com.kg.vista.ooba.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

import java.util.List;
import java.util.Random;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.BestCollectionViewPagerAdapter;
import com.kg.vista.ooba.adapter.BrandViewPagerAdapter;
import com.kg.vista.ooba.adapter.GrouponViewPagerAdapter;
import com.kg.vista.ooba.adapter.ShopRecyclerViewAdapter;
import com.kg.vista.ooba.model.Brand;
import com.kg.vista.ooba.model.Collection;
import com.kg.vista.ooba.model.Groupon;
import com.kg.vista.ooba.model.MainRequest;
import com.kg.vista.ooba.model.Shop;

import butterknife.BindView;
import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

    private UsersManagement usrData;

    private List<Groupon> grouponList;
    private List<Collection> collectionList;
    private List<Brand> brandList;
    private List<Shop> shopList;

    private CircleIndicator grouponCircleIndicator;
    private GrouponViewPagerAdapter grouponViewPagerAdapter;
    private ViewPager grouponViewPager;

    private BestCollectionViewPagerAdapter bestCollectionViewPagerAdapter;
    private ViewPager bestCollectionViewPager;
    private CircleIndicator bestCollectionCircleIndicator;

    private BrandViewPagerAdapter brandViewPagerAdapter;
    private ViewPager brandViewPager;
    private CircleIndicator brandCircleIndicator;
    private ShopRecyclerViewAdapter shopRecyclerViewAdapter;
    private RecyclerView shopRecyclerView;

    @BindView(R.id.world_shops_gv)
    GridView mWorldShopsGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        grouponViewPager = (ViewPager) findViewById(R.id.grouponViewPager);
        grouponCircleIndicator = (CircleIndicator) findViewById(R.id.groupon_circle_indicator);

        bestCollectionViewPager = (ViewPager) findViewById(R.id.bestCollectionViewPager);
        bestCollectionCircleIndicator = (CircleIndicator) findViewById(R.id.best_collection_circle_indicator);

        brandViewPager = (ViewPager) findViewById(R.id.brandViewPager);
        brandCircleIndicator = (CircleIndicator) findViewById(R.id.brand_circle_indicator);
        shopRecyclerView = (RecyclerView) findViewById(R.id.rec_view_shop);

        setUIFromAdapters();

    }
    private void setUIFromAdapters(){
        App.api().mainRequest().enqueue(new Callback<MainRequest>() {
            @Override
            public void onResponse(Call<MainRequest> call, Response<MainRequest> response) {
                if (!response.isSuccessful()){
                    return;
                }
                grouponList = response.body().getGroupon();
                collectionList = response.body().getCollection();
                brandList = response.body().getBrand();
                shopList = response.body().getShop();


                int randomNumber = new Random().nextInt(grouponList.size()) + 1;
                grouponViewPagerAdapter = new GrouponViewPagerAdapter(MainActivity.this, grouponList);
                grouponViewPager.setAdapter(grouponViewPagerAdapter);
                grouponViewPager.setCurrentItem(randomNumber);
                grouponCircleIndicator.setViewPager(grouponViewPager);


                int randomNumber1 = new Random().nextInt(collectionList.size())+1;
                bestCollectionViewPagerAdapter = new BestCollectionViewPagerAdapter(MainActivity.this, collectionList);
                bestCollectionViewPager.setAdapter(bestCollectionViewPagerAdapter);
                bestCollectionViewPager.setCurrentItem(randomNumber1);
                bestCollectionCircleIndicator.setViewPager(bestCollectionViewPager);

                int randomNumber2 = new Random().nextInt(brandList.size())+1;
                brandViewPagerAdapter = new BrandViewPagerAdapter(MainActivity.this, brandList);
                brandViewPager.setAdapter(brandViewPagerAdapter);
                brandViewPager.setCurrentItem(randomNumber2);
                brandCircleIndicator.setViewPager(brandViewPager);

                final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
                layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
                shopRecyclerViewAdapter = new ShopRecyclerViewAdapter(MainActivity.this, shopList);
                shopRecyclerView.setLayoutManager(layoutManager);
                shopRecyclerView.setHasFixedSize(true);
                shopRecyclerView.setAdapter(shopRecyclerViewAdapter);
                shopRecyclerView.addOnScrollListener(new CenterScrollListener());

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
        Log.d("user_id", "id "+USER_ID);
        if (Integer.parseInt(USER_ID) == 0) {
            setItemVisibility(false, View.INVISIBLE);
        }
        else {
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
    private void setItemVisibility(boolean visible, int visibility)
    {
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.sub_item).setVisible(visible);

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        UsersManagement usrData = new UsersManagement();
        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_basket) {
            // if user logged in start ShopActivity otherwise start LoginActivity
            Intent intent;
            String USER_ID = usrData.getUserData(this);
            if (Integer.parseInt(USER_ID) > 0) {
                //start activity shop
                Log.d("my_id", "id = "+USER_ID);
                intent = new Intent(this, ShopActivity.class);
            } else {
                //start activity login
                intent = new Intent(this, LoginActivity.class);
            }
            startActivity(intent);
        }
        else if (id == R.id.menu_notification){
            //start activity notifications
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
//        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
        switch(item.getItemId()){
            case R.id.nav_lenta:
                break;
            case R.id.nav_catalog:
                break;
            case R.id.nav_discount:
                break;
            case R.id.nav_collections:
                break;
            case R.id.nav_public:
                break;
            case R.id.nav_send:
                break;
            case R.id.nav_payments:
                Intent payments = new Intent(MainActivity.this, PaymentsStatusActivity.class);
                startActivity(payments);
                break;
            case R.id.nav_mail_forwarding:
                Intent mf = new Intent(MainActivity.this, MailForwardingActivity.class);
                startActivity(mf);
                break;
            case R.id.nav_partner_program:
                Intent partner = new Intent(MainActivity.this, PartnerActivity.class);
                startActivity(partner);
                break;
            case R.id.nav_my_group_shopings:
                Intent groupOn = new Intent(MainActivity.this, GroupOnActivity.class);
                startActivity(groupOn);
                break;
            case R.id.nav_my_collections:
                break;
            case R.id.nav_user_details:
                Intent userDetails = new Intent(MainActivity.this, UserDetailsActivity.class);
                startActivity(userDetails);
                break;
            case R.id.nav_security:
                Intent security = new Intent(MainActivity.this, SecurityActivity.class);
                startActivity(security);
                break;
            case R.id.nav_mail_settings:
                Intent mail_settings =new Intent(MainActivity.this, PostSettingsActivity.class);
                startActivity(mail_settings);
                break;
            case R.id.nav_logout:
                usrData.setUserData(MainActivity.this, "0");

                loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
                loginPrefsEditor = loginPreferences.edit();
                loginPrefsEditor.putBoolean("hasLoggedIn", false);
                loginPrefsEditor.commit();
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
