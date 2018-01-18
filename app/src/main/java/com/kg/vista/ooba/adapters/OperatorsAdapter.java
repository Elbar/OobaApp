package com.kg.vista.ooba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Item.OperatorItem;

public class OperatorsAdapter extends BaseAdapter {

    private Context contxt;
    private LayoutInflater lInflater;
    private ArrayList<OperatorItem> operatorItem;

    public OperatorsAdapter(Context context, ArrayList<OperatorItem> operator) {
        contxt = context;
        operatorItem = operator;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return operatorItem.size();
    }

    @Override
    public Object getItem(int position) {
        return operatorItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.operator, parent, false);
        }

        OperatorItem o = getOperator(position);

        ((TextView) view.findViewById(R.id.operName)).setText(o.getOperName());
        ((ImageView) view.findViewById(R.id.operIcon)).setImageResource(o.getOperIcon());

        return view;
    }

    OperatorItem getOperator(int position) {
        return ((OperatorItem) getItem(position));
    }
}
