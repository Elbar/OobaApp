package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Item.GroupItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class GroupOnAdapter extends BaseAdapter {
    private Context contxt;
    private LayoutInflater lInflater;
    private ArrayList<GroupItem> groupItem;

    private ImageView image;

    public GroupOnAdapter(Context context, ArrayList<GroupItem> group) {
        contxt = context;
        groupItem = group;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return groupItem.size();
    }

    @Override
    public Object getItem(int position) {
        return groupItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.group, parent, false);
        }

        GroupItem g = getGroup(position);

        image = (ImageView) view.findViewById(R.id.groupImg);
        Picasso.with(contxt).load(g.getImage()).into(image);

        ((TextView) view.findViewById(R.id.groupName)).setText(g.getTitle());
//        ((TextView) view.findViewById(R.id.newCost)).setText(g.get);
//        ((TextView) view.findViewById(R.id.discount)).setText(g.getDiscount());
        TextView tv = (TextView) view.findViewById(R.id.oldCost);
        tv.setText(g.getPrice());
        tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        return view;
    }

    GroupItem getGroup(int position) {
        return ((GroupItem) getItem(position));
    }
}
