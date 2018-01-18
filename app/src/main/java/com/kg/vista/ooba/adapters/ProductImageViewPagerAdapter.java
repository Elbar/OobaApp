package com.kg.vista.ooba.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;



public class ProductImageViewPagerAdapter extends PagerAdapter {

    Context context;
    List<String> imageList;
    LayoutInflater inflater;

    public ProductImageViewPagerAdapter(Context context, List<String> imageList){
        this.context = context;
        this.imageList = imageList;
        inflater = LayoutInflater.from(context);
        Log.d("product_image", "images length "+getCount());
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = inflater.inflate(R.layout.product_image_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.productImageItem);
        //final ProgressBar progressBar = (ProgressBar) itemView.findViewById(R.id.brandProgressBar);

        //Log.d("ooba2", "price "+groupon.getPrice());
        Picasso.with(context).load(imageList.get(position)).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                //progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                //progressBar.setVisibility(View.INVISIBLE);
            }
        });

        container.addView(itemView);

        return itemView;
    }

    @Override
    public int getCount() {
        return imageList.size();
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