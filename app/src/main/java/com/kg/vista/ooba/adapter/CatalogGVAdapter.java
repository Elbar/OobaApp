package com.kg.vista.ooba.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.activity.ShopInDetailActivity;
import com.kg.vista.ooba.model.Catalog;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CatalogGVAdapter extends BaseAdapter {

    private final List<Catalog> catalogs;
    Context context;
    Context mContext;

    public CatalogGVAdapter(Context context, List<Catalog> catalogs) {
        this.mContext = context;
        this.catalogs = catalogs;
    }


    @Override
    public int getCount() {
        return catalogs.size();
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


        final Catalog catalog = catalogs.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.catalog_item, null);
        }

        ImageView imageView  = (ImageView) convertView.findViewById(R.id.shop_image);
        CardView mCatalogCV = (CardView) convertView.findViewById(R.id.catalog_cv);
        final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.shopProgressBar);

        Picasso.with(context).load("http://ooba.kg/"+catalog.getLinkLogo()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        mCatalogCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, ShopInDetailActivity.class);
                intent.putExtra("index_shop", catalog.getIndexShop());
                mContext.startActivity(intent);

            }
        });


        return convertView;
    }


}
