package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;

import java.util.List;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.MyViewHolder> {

    private List<String> categories;
    public String TAG = "CategoryRVAdapter";
    Context context;

    public CategoryRVAdapter( List<String> categories) {
        this.categories = categories;
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

        holder.title.setText(category);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        String mItem;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.category_name);
        }
    }
}