package com.kg.vista.ooba.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;

import org.w3c.dom.Text;

import butterknife.BindView;


public class ShopInDetailActivity extends AbstractActivity {


    @BindView(R.id.shop_banner)
    ImageView mShopBanner;
    @BindView(R.id.shop_country_tv)
    TextView mShopCountryTV;
    @BindView(R.id.shop_about_us_tv)
    TextView mShopAboutUsTV;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_in_detail);

        Intent intent = getIntent();
        String indexShop = intent.getStringExtra("index_shop");
        String linkUrl = intent.getStringExtra("link_url");
        String desc = intent.getStringExtra("desc");
        String filter = intent.getStringExtra("filter");

        Toast.makeText(this, indexShop, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, linkUrl, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, filter, Toast.LENGTH_SHORT).show();

    }
}
