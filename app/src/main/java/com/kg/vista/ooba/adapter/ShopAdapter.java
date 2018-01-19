package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Shop;

import java.util.List;

public class ShopAdapter extends BaseAdapter {

    private final List<Shop> shops;
    Context mContext;

    public ShopAdapter(Context context, List<Shop> shops) {
        this.mContext = context;
        this.shops = shops;
    }


    @Override
    public int getCount() {
        return shops.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final Shop shop = shops.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.row_layout_shop, null);
        }

        TextView mTestView = (TextView) convertView.findViewById(R.id.test_tv);

        mTestView.setText(shop.getName());


        return convertView;
    }


}
