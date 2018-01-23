package com.kg.vista.ooba.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.kg.vista.ooba.R;


public class ShopInDetailActivity extends AbstractActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_in_detail);

        Intent intent = getIntent();
        String indexShop = intent.getStringExtra("index_shop");

        Toast.makeText(this, indexShop, Toast.LENGTH_SHORT).show();

    }
}
