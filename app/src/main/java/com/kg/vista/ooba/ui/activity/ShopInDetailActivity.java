package com.kg.vista.ooba.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.CategoryRVAdapter;
import com.kg.vista.ooba.model.Category;
import com.kg.vista.ooba.model.Child;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;


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

    @BindView(R.id.show_more_info_tv)
    TextView mShowMoreInfoTV;
    @BindView(R.id.category_rv)
    RecyclerView mCategoryRV;
    CategoryRVAdapter categoryRVAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_in_detail);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String indexShop = intent.getStringExtra("index_shop");
        String linkUrl = intent.getStringExtra("link_url");
        String linkLogo = intent.getStringExtra("link_logo");
        final String desc = intent.getStringExtra("desc");
        String filter = intent.getStringExtra("filter");


        mShowMoreInfoTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShopAboutUsWV.getSettings().setDefaultTextEncodingName("utf-8");
                mShopAboutUsWV.setBackgroundColor(Color.TRANSPARENT);
                mShopAboutUsWV.loadData(desc, "text/html; charset=utf-8", "utf-8");


            }
        });


        Picasso.with(ShopInDetailActivity.this).load(linkLogo).into(mShopBanner, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });


        mShopCountryLinkTV.setText(linkUrl);
        mShopMainCategoryTV.setText(filter);

//        getShopByIndex(indexShop);
        getShopDetail(indexShop);
        getCategories(indexShop);
        getSubCategories(indexShop);

    }

    public void getShopDetail(final String indexShop) {
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
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                final String json = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("MESSAGE", json);
                        try {

                            JSONObject menu = new JSONObject(json);
                            JSONObject shop = menu.getJSONObject("shop");
                            Log.e("JSJ", shop.toString());
                            String country = shop.getString("country");
                            String shortDesc = shop.getString("short_desc");
                            mShopCountryTV.setText(country);
                            mShopAboutUsWV.getSettings().setDefaultTextEncodingName("utf-8");
                            mShopAboutUsWV.setBackgroundColor(Color.TRANSPARENT);
                            mShopAboutUsWV.loadData(shortDesc, "text/html; charset=utf-8", "utf-8");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

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

                            categoryRVAdapter = new CategoryRVAdapter(ShopInDetailActivity.this, categories);

                            mCategoryRV.setLayoutManager(new GridLayoutManager(ShopInDetailActivity.this, 2));

                            mCategoryRV.setAdapter(categoryRVAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }

    public void getSubCategories(final String indexShop) {


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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            JSONObject menu = new JSONObject(json);
                            JSONArray category = menu.getJSONArray("category");

                            List<Category> categories = new ArrayList<>();

                            for (int i = 0; i < category.length(); i++) {
                                JSONObject cat = category.getJSONObject(i);
                                String catName = cat.getString("cat_name");

                                JSONArray child = cat.getJSONArray("child");
                                Log.e("DADF", child.toString());
                                for (int j = 0; j < child.length(); j++) {
                                    JSONArray childJsonArray = child.getJSONArray(j);
                                    JSONObject contentJsonObject = childJsonArray.getJSONObject(j);
                                    Category category1 = new Category();
                                    category1.setCatName(contentJsonObject.getString("cat_name"));
                                    category1.setCatName(contentJsonObject.getString("cat_id"));

                                    categories.add(category1);


                                }
                            }
//
                            categoryRVAdapter = new CategoryRVAdapter(ShopInDetailActivity.this, categories);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }


}
