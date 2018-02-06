package com.kg.vista.ooba.ui.activity;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.ui.fragment.CatalogFragment;
import com.kg.vista.ooba.ui.fragment.CollectionFragment;
import com.kg.vista.ooba.ui.fragment.DiscountFragment;
import com.kg.vista.ooba.ui.fragment.HomeFragment;
import com.kg.vista.ooba.ui.fragment.PublicFragment;

import butterknife.ButterKnife;

public class Main2Activity extends AbstractActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


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

        final LinearLayoutManager whatsNewLinearLayoutManager = new LinearLayoutManager(Main2Activity.this, LinearLayoutManager.VERTICAL, false);


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

        int id = item.getItemId();

        switch (id) {
            case R.id.nav_lenta:
                HomeFragment homeFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, homeFragment)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.nav_catalog:
                CatalogFragment catalogFragment = new CatalogFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, catalogFragment)
                        .addToBackStack(null)
                        .commit();
                break;


            case R.id.nav_discount:
                DiscountFragment discountFragment = new DiscountFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, discountFragment)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.nav_collections:

                CollectionFragment collectionFragment = new CollectionFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, collectionFragment)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.nav_public:

                PublicFragment publicFragment = new PublicFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, publicFragment)
                        .addToBackStack(null)
                        .commit();
                break;


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
