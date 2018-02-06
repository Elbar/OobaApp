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
import com.kg.vista.ooba.model.Collection;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;


public class BestCollectionRecyclerViewAdapter extends RecyclerView.Adapter<BestCollectionRecyclerViewAdapter.MyViewHolder> {

    public String TAG = "BestCollectionTag";
    Context context;
    private List<Collection> collections;

    public BestCollectionRecyclerViewAdapter(List<Collection> collections) {
        this.collections = collections;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.best_collection_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Collection collection = collections.get(position);

        holder.title.setText(collection.getTitle());
        holder.info.setText(collection.getInfo());

//
        Picasso.with(context).load("http://ooba.kg/" + collection.getPicUrl()).into(holder.imageView, new Callback() {
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
        return collections.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, info;
        public ImageView imageView;
        ProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.best_collections_title);
            info = (TextView) view.findViewById(R.id.best_collection_info);
            progressBar = (ProgressBar) view.findViewById(R.id.bestCollectionProgressBar);
            imageView = (ImageView) view.findViewById(R.id.best_collections_image);

        }
    }
}