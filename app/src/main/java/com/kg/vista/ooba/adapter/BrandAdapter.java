package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Brand;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;


public class BrandAdapter extends BaseAdapter {

    private final List<Brand> brands;
    Context mContext;

    public BrandAdapter(Context context, List<Brand> brands) {
        this.mContext = context;
        this.brands = brands;
    }


    @Override
    public int getCount() {
        return brands.size();
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


            final Brand brand = brands.get(position);


            if (convertView == null) {
                final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
                convertView = layoutInflater.inflate(R.layout.brand_item, null);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.brand_image);
            final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.brandProgressBar);
        Picasso.with(mContext).load("http://ooba.kg/data/brandlogo/"+brand.getBrandLogo()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        return convertView;

    }


}
