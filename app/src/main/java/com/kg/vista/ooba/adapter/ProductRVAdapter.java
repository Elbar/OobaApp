package com.kg.vista.ooba.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.activity.ProductDetailActivity;
import com.kg.vista.ooba.model.Product2;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductRVAdapter extends RecyclerView.Adapter<ProductRVAdapter.ViewHolder> {

    private List<Product2> mItems;

    public ProductRVAdapter() {
        mItems = new ArrayList<>();
    }

    public ProductRVAdapter(List<Product2> items) {
        mItems = new ArrayList<>(items);
    }

    public void setItems(List<Product2> items) {
        mItems = new ArrayList<Product2>(items);

        this.notifyDataSetChanged();
    }

    public void addItems(List<Product2> items) {
        mItems.addAll(items);
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mItems.get(position);

        Picasso.with(holder.mView.getContext()).load(holder.mItem.getImages()).resize(600,600).into(holder.mProductIV);

        holder.mProductName.setText(holder.mItem.getNickTitle());
        String price = String.valueOf(holder.mItem.getPrice());
        holder.mProductPriceTV.setText(price + " сом ");

        holder.mProductCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.mView.getContext(), ProductDetailActivity.class);
                holder.mView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        @BindView(R.id.product_name)
        TextView mProductName;
        @BindView(R.id.product_iv)
        ImageView mProductIV;

        @BindView(R.id.product_cv)
        CardView mProductCV;
        Product2 mItem;

        @BindView(R.id.product_price_tv)
        TextView mProductPriceTV;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mView = view;
        }
    }
}
