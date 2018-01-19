package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import java.util.ArrayList;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Item.AddressItem;


public class AddressOptionAdapter extends BaseAdapter{

    private Context contxt;
    private LayoutInflater lInflater;
    private ArrayList<AddressItem> addressOptionItem;
    private RadioButton checkedRadioBtn;
    int selectedPosition = 0;

    public AddressOptionAdapter(Context context, ArrayList<AddressItem> addressOptionItem) {
        contxt = context;
        this.addressOptionItem=addressOptionItem;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return addressOptionItem.size();
    }

    @Override
    public Object getItem(int position) {
        return addressOptionItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.address_radio_button, parent, false);
        }

        AddressItem aoi = getAddressOption(position);

        checkedRadioBtn =(RadioButton) view.findViewById(R.id.addressBtn);
        checkedRadioBtn.setText(aoi.getName()+" \n"+aoi.getAddress()+" \n"+aoi.getPhone());
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
    AddressItem getAddressOption(int position) {
        return ((AddressItem) getItem(position));
    }
}
