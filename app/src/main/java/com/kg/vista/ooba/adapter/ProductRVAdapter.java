package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.activity.Product2Activity;
import com.kg.vista.ooba.model.Product2;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProductRVAdapter extends RecyclerView.Adapter<ProductRVAdapter.MyViewHolder> {

    private List<Product2> products;
    private List<String> subCategories;
    public String TAG = "ProductRVAdapter";
    Context context;

    public ProductRVAdapter(Context context, List<Product2> products) {

        this.products = products;
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

//        final String subcategory = subCategories.get(position);

//        holder.title.setText(category);
        Picasso.with(context).load(R.drawable.noimage).into(holder.mCategoryIV);

        holder.mCategoryCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(context, subcategory, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Product2Activity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
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