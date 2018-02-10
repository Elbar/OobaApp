package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Product2;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductRVAdapter extends RecyclerView.Adapter<ProductRVAdapter.MyViewHolder> {

    public String TAG = "CategoryRVAdapter";
    Context context;
    private List<Product2> product2s;

    public ProductRVAdapter(Context context, List<Product2> product2s) {

        this.product2s = product2s;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_product, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        final Product2 product2 = product2s.get(position);

        final String name = String.valueOf(product2.getNickTitle());
        final String price = String.valueOf(product2.getPrice());
        final String urlProduct = product2.getUrlProduct().substring(1);
        String nickTitle = product2.getNickTitle();

        String imgUrl = product2.getImages();
        holder.mProductPriceTV.setText(price + " сом ");
        holder.mNickTitleTV.setText(nickTitle);
        holder.mShopNameTV.setText("d");

        Picasso.with(holder.mView.getContext()).load(imgUrl).into(holder.mProductIV);
    }

    @Override
    public int getItemCount() {
        return product2s.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        final View mView;

        @BindView(R.id.nick_title_tv)
        TextView mNickTitleTV;
        @BindView(R.id.shop_name_tv)
        TextView mShopNameTV;

        @BindView(R.id.product_iv)
        ImageView mProductIV;

        @BindView(R.id.product_cv)
        CardView mProductCV;
        Product2 mItem;

        @BindView(R.id.product_price_tv)
        TextView mProductPriceTV;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mView = view;
        }
    }
}