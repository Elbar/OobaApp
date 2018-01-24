package com.kg.vista.ooba.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShopInDetailActivity extends AbstractActivity {


    @BindView(R.id.shop_banner)
    ImageView mShopBanner;
    @BindView(R.id.shop_country_tv)
    TextView mShopCountryTV;
    @BindView(R.id.shop_about_us_wv)
    WebView mShopAboutUsWV;
    @BindView(R.id.shop_country_link_tv)
    TextView mShopCountryLinkTV;
    @BindView(R.id.shop_main_category_tv)
    TextView mShopMainCategoryTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_in_detail);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String indexShop = intent.getStringExtra("index_shop");
        String linkUrl = intent.getStringExtra("link_url");
        String linkLogo = intent.getStringExtra("link_logo");
        String desc = intent.getStringExtra("desc");
        String filter = intent.getStringExtra("filter");


        Picasso.with(ShopInDetailActivity.this).load(linkLogo).into(mShopBanner, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });

        mShopAboutUsWV.getSettings().setDefaultTextEncodingName("utf-8");
        mShopAboutUsWV.setBackgroundColor(Color.TRANSPARENT);
        mShopAboutUsWV.loadData(desc, "text/html; charset=utf-8", "utf-8");

        mShopCountryLinkTV.setText(linkUrl);
        mShopMainCategoryTV.setText(filter);

    }
}
