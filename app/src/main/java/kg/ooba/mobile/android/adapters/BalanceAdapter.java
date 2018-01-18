package kg.ooba.mobile.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.model.Item.BalanceItem;

/**
 * Created by aizhan on 9/4/17.
 */

public class BalanceAdapter extends BaseAdapter {

    private Context contxt;
    private LayoutInflater lInflater;
    private ArrayList<BalanceItem> balances;

    public BalanceAdapter(Context context, ArrayList<BalanceItem> balance) {
        contxt = context;
        balances = balance;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return balances.size();
    }

    @Override
    public Object getItem(int position) {
        return balances.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.balance, parent, false);
        }

        BalanceItem b = getBalance(position);

        ((TextView) view.findViewById(R.id.balanceDate)).setText(b.getDate());
        ((TextView) view.findViewById(R.id.balanceStatus)).setText(b.getPurpose());
        ((TextView) view.findViewById(R.id.balanceSum)).setText(String.valueOf(b.getAmount()));

        return view;
    }

    BalanceItem getBalance(int position) {
        return ((BalanceItem) getItem(position));
    }
}
