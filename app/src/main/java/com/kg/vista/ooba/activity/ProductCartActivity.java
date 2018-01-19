package com.kg.vista.ooba.activity;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.TabAdapter;

public class ProductCartActivity extends AbstractActivity {

    private ViewPager viewPager;
    private TabAdapter tabAdapter;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_cart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.product_cart_toolbar);
        toolbar.setTitle("Product");
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);

        fragmentManager = getSupportFragmentManager();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Инфо"));
        tabLayout.addTab(tabLayout.newTab().setText("Продавец"));
        tabLayout.addTab(tabLayout.newTab().setText("Отзывы"));

        viewPager = (ViewPager) findViewById(R.id.view_pager_product_cart);
        tabAdapter = new TabAdapter(fragmentManager, 3);
        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
