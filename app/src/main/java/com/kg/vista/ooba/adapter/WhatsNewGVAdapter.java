package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.WhatsNew;
import com.squareup.picasso.Picasso;

import java.util.List;


public class WhatsNewGVAdapter extends BaseAdapter {

    private final List<WhatsNew> whatsNewList;
    Context mContext;

    public WhatsNewGVAdapter(Context context, List<WhatsNew> whatsNewList) {
        this.mContext = context;
        this.whatsNewList = whatsNewList;
    }

    @Override
    public int getCount() {
        return whatsNewList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final WhatsNew whatsNew = whatsNewList.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.whats_new_item, null);
        }

        final ImageView brandLogoIV = (ImageView) convertView.findViewById(R.id.item_image);
//        TextView mItemTitle = (TextView) convertView.findViewById(R.id.item_title);

        Picasso.with(mContext).load(whatsNew.getFileUrl()).resize(400, 400).into(brandLogoIV);

//        mItemTitle.setText(whatsNew.getTitle());

        return convertView;
    }

}