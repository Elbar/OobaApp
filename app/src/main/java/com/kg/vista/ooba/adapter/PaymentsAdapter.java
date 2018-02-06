package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Item.PaymentsItem;

import java.util.ArrayList;


public class PaymentsAdapter extends BaseAdapter {

    private Context contxt;
    private LayoutInflater lInflater;
    private ArrayList<PaymentsItem> paymentsItems;

    public PaymentsAdapter(Context context, ArrayList<PaymentsItem> payments) {
        contxt = context;
        paymentsItems = payments;
        lInflater = (LayoutInflater) contxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return paymentsItems.size();
    }

    @Override
    public Object getItem(int position) {
        return paymentsItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.payments, parent, false);
        }

        PaymentsItem p = getPayments(position);

        ((TextView) view.findViewById(R.id.paymentDate)).setText(p.getDate());
        ((TextView) view.findViewById(R.id.paymentStatus)).setText(p.getPurpose());
        ((TextView) view.findViewById(R.id.orderNum)).setText(p.getOrderNumber());
        ((TextView) view.findViewById(R.id.invoiceNum)).setText(p.getInvoiceNumber());
        ((TextView) view.findViewById(R.id.out_Paysum)).setText(String.valueOf(p.getAmount()));

        return view;
    }

    PaymentsItem getPayments(int position) {
        return ((PaymentsItem) getItem(position));
    }
}
