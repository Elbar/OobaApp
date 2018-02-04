package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Store;
import com.kg.vista.ooba.ui.activity.ShopInDetailActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopAdapter extends BaseAdapter {

    private final List<Store> shops;
    Context context;
    Context mContext;

    public ShopAdapter(Context context, List<Store> shops) {
        this.mContext = context;
        this.shops = shops;
    }


    @Override
    public int getCount() {
        return shops.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final Store shop = shops.get(position);
        String shopName = shop.getName();



        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.shop_item, null);
        }

        ImageView imageView  = (ImageView) convertView.findViewById(R.id.shop_image);
        final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.shopProgressBar);

        Picasso.with(context).load("http://ooba.kg/"+shop.getLogo()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, ShopInDetailActivity.class);
                intent.putExtra("index_shop", shop.getName());
                mContext.startActivity(intent);

            }
        });


        return convertView;
    }


}
