package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import com.kg.vista.ooba.model.Item.PartnerItem;



public class PartnerAdapter extends BaseAdapter {

    private Context contxt;
    private LayoutInflater lInflater;
    private ArrayList<PartnerItem> partnerItems;

    private ImageView image;

    public PartnerAdapter(Context context, ArrayList<PartnerItem> partner) {
        contxt = context;
        partnerItems = partner;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return partnerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return partnerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.partner, parent, false);
        }

        PartnerItem p = getPartner(position);

        image = (ImageView) view.findViewById(R.id.partnerImg);
        Picasso.with(contxt).load(p.getPicUrl()).into(image);
        ((TextView) view.findViewById(R.id.outPromoCode)).setText(p.getPromoCode());

        return view;
    }

    PartnerItem getPartner(int position) {
        return ((PartnerItem) getItem(position));
    }
}
