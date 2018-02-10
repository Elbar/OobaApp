package com.kg.vista.ooba.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Catalog;
import com.kg.vista.ooba.ui.activity.ShopInDetailActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CatalogGVAdapter extends BaseAdapter {

    private final List<Catalog> catalogs;
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

        ImageView imageView = (ImageView) convertView.findViewById(R.id.shop_image);
        WebView mShopShortDescWV = (WebView) convertView.findViewById(R.id.shop_short_desc);
        final TextView mLinkNameTV = (TextView) convertView.findViewById(R.id.shop_link_name_tv);
        TextView mShopFilterTV = (TextView) convertView.findViewById(R.id.shop_filter_tv);
        CardView mCatalogCV = (CardView) convertView.findViewById(R.id.catalog_cv);
        final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.shopProgressBar);

        mShopShortDescWV.getSettings().setDefaultTextEncodingName("utf-8");
        mShopShortDescWV.setBackgroundColor(Color.TRANSPARENT);
        mShopShortDescWV.loadData(catalog.getShortDesc(), "text/html; charset=utf-8", "utf-8");
        final String shopLink = catalog.getLinkName();

        mLinkNameTV.setText(shopLink);

        mShopFilterTV.setText(catalog.getFilter());


        final String linkLogo = "http://ooba.kg/" + catalog.getLinkLogo();


        Picasso.with(mContext).load(linkLogo).into(imageView, new Callback() {
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
                intent.putExtra("link_url", catalog.getLinkUrl());
                intent.putExtra("link_logo", linkLogo);
                intent.putExtra("desc", catalog.getDescription());
                intent.putExtra("filter", catalog.getFilter());

                mContext.startActivity(intent);

            }
        });


        return convertView;
    }


}
