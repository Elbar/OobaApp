package com.kg.vista.ooba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Item.MailForwardingItem;


public class MailForwardingAdapter extends BaseAdapter{

    private Context contxt;
    private LayoutInflater lInflater;
    private ArrayList<MailForwardingItem> mailForwardings;

    private ImageButton deleteBtn;

    public MailForwardingAdapter(Context context, ArrayList<MailForwardingItem> mailForwarding) {
        contxt = context;
        mailForwardings = mailForwarding;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mailForwardings.size();
    }

    @Override
    public Object getItem(int position) {
        return mailForwardings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.mail_forwarding, parent, false);
        }

        MailForwardingItem m = getMailForwarding(position);

        ((TextView) view.findViewById(R.id.trekNumber)).setText(m.getTrekNumber());
        ((TextView) view.findViewById(R.id.goodType)).setText(m.getGoodType());

        deleteBtn = (ImageButton) view.findViewById(R.id.rekDel);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mailForwardings.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    MailForwardingItem getMailForwarding(int position) {
        return ((MailForwardingItem) getItem(position));
    }
}
