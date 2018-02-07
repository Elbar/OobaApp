package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.PublicGood;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PublicRVAdapter extends RecyclerView.Adapter<PublicRVAdapter.MyViewHolder> {

    Context context;
    private List<PublicGood> publicGoods;

    public PublicRVAdapter(Context context, List<PublicGood> publicGoods) {

        this.publicGoods = publicGoods;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_public, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        PublicGood publicGood = publicGoods.get(position);
        holder.mPublicTitleTV.setText(publicGood.getTitle());
        holder.mPublicInfoTV.setText(publicGood.getDescription());

        Picasso.with(context).load("http://ooba.kg/" + publicGood.getFileUrl()).into(holder.mPublicIV);

        holder.mPublicCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                Intent intent = new Intent(context, ProductActivity.class);
//                intent.putExtra("cat_id", "ds");
//                context.startActivity(intent);
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return publicGoods.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mPublicTitleTV;
        TextView mPublicInfoTV;
        ImageView mPublicIV;
        CardView mPublicCV;


        MyViewHolder(View view) {

            super(view);
            mPublicTitleTV = (TextView) view.findViewById(R.id.public_good_title_tv);
            mPublicInfoTV = (TextView) view.findViewById(R.id.public_good_info_tv);
            mPublicIV = (ImageView) view.findViewById(R.id.public_iv);
            mPublicCV = (CardView) view.findViewById(R.id.public_cv);

        }
    }
}