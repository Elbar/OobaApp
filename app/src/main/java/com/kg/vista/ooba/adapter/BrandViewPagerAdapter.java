package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import com.kg.vista.ooba.model.Brand;


public class BrandViewPagerAdapter extends PagerAdapter {

    Context context;
    List<Brand> brandList;
    LayoutInflater inflater;

    public BrandViewPagerAdapter(Context context, List<Brand> brandList){
        this.context = context;
        this.brandList = brandList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = inflater.inflate(R.layout.brand_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.brand_image);
        TextView tvTitle = (TextView) itemView.findViewById(R.id.brand_title);
        final ProgressBar progressBar = (ProgressBar) itemView.findViewById(R.id.brandProgressBar);
        Brand brand = brandList.get(position);
        //Log.d("ooba2", "price "+groupon.getPrice());
        tvTitle.setText(brand.getBrandName());
        Picasso.with(context).load("http://ooba.kg/data/brandlogo/"+brand.getBrandLogo()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        container.addView(itemView);

        return itemView;
    }

    @Override
    public int getCount() {
        return brandList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //if error cast container to view pager
        container.removeView((LinearLayout) object);
    }
}
