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
import com.kg.vista.ooba.model.Category;
import com.kg.vista.ooba.ui.activity.ProductActivity;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.MyViewHolder> {

    public String TAG = "CategoryRVAdapter";
    Context context;
    private List<Category> categories;


    public DiscountAdapter(Context context, List<Category> categories) {

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


        Category category = categories.get(position);
        final String catID = category.getCatId();


        holder.title.setText(category.getCatName());
        Picasso.with(context).load(R.drawable.noimage).into(holder.mCategoryIV);

        holder.mCategoryCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("cat_id", catID);
                context.startActivity(intent);
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

        MyViewHolder(View view) {

            super(view);
            title = (TextView) view.findViewById(R.id.category_name);
            mCategoryIV = (ImageView) view.findViewById(R.id.category_iv);
            mCategoryCV = (CardView) view.findViewById(R.id.category_cv);
        }
    }
}