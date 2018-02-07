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
import com.kg.vista.ooba.model.Discount;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DiscountRVAdapter extends RecyclerView.Adapter<DiscountRVAdapter.MyViewHolder> {

    Context context;
    private List<Discount> discounts;

    public DiscountRVAdapter(Context context, List<Discount> discounts) {

        this.discounts = discounts;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_discount, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Discount discount = discounts.get(position);
        holder.discountGoodName.setText(discount.getGoodsName());
        holder.mDiscountPriceTV.setText(discount.getPrice() + " сом");
        String totalPrice = String.valueOf(discount.getPriceTotal());
        String percent = String.valueOf(discount.getPercent());
        holder.mDiscountPriceTotalTV.setText(totalPrice + " cом");
        holder.mDiscountPercentTV.setText(percent + "%");
        Picasso.with(context).load(discount.getPicUrl()).into(holder.mDiscountIV);

        holder.mDiscountCV.setOnClickListener(new View.OnClickListener() {
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
        return discounts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView discountGoodName;
        ImageView mDiscountIV;
        CardView mDiscountCV;
        TextView mDiscountPriceTotalTV;
        TextView mDiscountPriceTV;
        TextView mDiscountPercentTV;

        MyViewHolder(View view) {

            super(view);
            discountGoodName = (TextView) view.findViewById(R.id.discount_good_name_tv);
            mDiscountIV = (ImageView) view.findViewById(R.id.discount_iv);
            mDiscountCV = (CardView) view.findViewById(R.id.discount_cv);
            mDiscountPriceTV = (TextView) view.findViewById(R.id.discount_price_tv);
            mDiscountPriceTotalTV = (TextView) view.findViewById(R.id.discount_price_total_tv);
            mDiscountPercentTV = (TextView) view.findViewById(R.id.discount_percent_tv);

        }
    }
}