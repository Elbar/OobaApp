package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.MyViewHolder> {

    private List<String> categories;
    private List<String> subCategories;
    public String TAG = "CategoryRVAdapter";
    Context context;

    public CategoryRVAdapter(Context context, List<String> categories, List<String> subCategories) {

        this.categories = categories;
        this.subCategories = subCategories;
        this.context = context;
    }

    public CategoryRVAdapter(Context context, List<String> categories)  {

        this.categories = categories;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_category, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        String category = categories.get(position);
//        final String subcategory = subCategories.get(position);

        holder.title.setText(category);
        Picasso.with(context).load(R.drawable.noimage).into(holder.mCategoryIV);

        holder.mCategoryCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(context, subcategory, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView mCategoryIV;
        CardView mCategoryCV;
        String mItem;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.category_name);
            mCategoryIV = (ImageView) view.findViewById(R.id.category_iv);
            mCategoryCV = (CardView) view.findViewById(R.id.category_cv);
        }
    }
}