package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import java.util.ArrayList;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Item.ShippingItem;



public class ShippingOptionAdapter extends BaseAdapter{

    private Context contxt;
    private LayoutInflater lInflater;
    private ArrayList<ShippingItem> shippingItem;
    int selectedPosition = 0;
    private RadioButton checkedRadioBtn;

    public ShippingOptionAdapter(Context context, ArrayList<ShippingItem> shippingItem) {
        contxt = context;
        this.shippingItem=shippingItem;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return shippingItem.size();
    }

    @Override
    public Object getItem(int position) {
        return shippingItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.shipping_radio_button, parent, false);
        }

        ShippingItem s = getShippingOption(position);

        checkedRadioBtn = (RadioButton) view.findViewById(R.id.shippingBtn);
        checkedRadioBtn.setText(s.getShippingName()+" \n"+s.getShippingDesc());
        checkedRadioBtn.setChecked(position == selectedPosition);
        checkedRadioBtn.setTag(position);
        checkedRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = (Integer)view.getTag();
                notifyDataSetChanged();
            }
        });

        return view;
    }
    public int getPosition() {
        return selectedPosition;
    }
    ShippingItem getShippingOption(int position) {
        return ((ShippingItem) getItem(position));
    }
}