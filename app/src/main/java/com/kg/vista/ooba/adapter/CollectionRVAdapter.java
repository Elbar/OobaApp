package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Collection;
import com.kg.vista.ooba.model.CollectionGood;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CollectionRVAdapter extends RecyclerView.Adapter<CollectionRVAdapter.MyViewHolder> {

    Context context;
    private List<CollectionGood> collections;

    public CollectionRVAdapter(Context context, List<CollectionGood> collections) {

        this.collections = collections;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_collection, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        CollectionGood collectionGood = collections.get(position);
        holder.discountGoodName.setText(collectionGood.getTitle());
        Picasso.with(context).load("http://ooba.kg" + collectionGood.getPicUrl()).into(holder.mDiscountIV);

    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView discountGoodName;
        ImageView mDiscountIV;


        MyViewHolder(View view) {

            super(view);
            discountGoodName = (TextView) view.findViewById(R.id.discount_good_name_tv);
            mDiscountIV = (ImageView) view.findViewById(R.id.discount_iv);


        }
    }
}