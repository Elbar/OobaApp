package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import com.kg.vista.ooba.model.Shop;



public class ShopRecyclerViewAdapter extends RecyclerView.Adapter<ShopRecyclerViewAdapter.MyViewHolder> {


    Context context;
    List<Shop> shopList;
    LayoutInflater inflater;

    public ShopRecyclerViewAdapter(Context context, List<Shop> shopList){
        this.context = context;
        this.shopList = shopList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Shop shop = shopList.get(position);
        holder.tvTitle.setText(shop.getName());
        Picasso.with(context).load("http://ooba.kg/"+shop.getLogo()).into(holder.imageView, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                holder.progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView tvTitle;
        ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView  = (ImageView) itemView.findViewById(R.id.shop_image);
            tvTitle = (TextView) itemView.findViewById(R.id.shop_title);
            progressBar = (ProgressBar) itemView.findViewById(R.id.shopProgressBar);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }
    }
}
