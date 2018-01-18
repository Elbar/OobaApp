package kg.ooba.mobile.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.model.Item.NotificationItem;

/**
 * Created by aizhan on 9/9/17.
 */

public class NotificationAdapter extends BaseAdapter{
    Context contxt;
    LayoutInflater lInflater;
    ArrayList<NotificationItem> notificationItem;

    public NotificationAdapter(Context context, ArrayList<NotificationItem> notification) {
        contxt = context;
        notificationItem = notification;
        lInflater = (LayoutInflater) LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return notificationItem.size();
    }

    @Override
    public Object getItem(int position) {
        return notificationItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.notification, parent, false);
        }

        NotificationItem n = getNotification(position);

        ((TextView) view.findViewById(R.id.notifDate)).setText(n.getAddTime());
        ((TextView) view.findViewById(R.id.notifText)).setText(n.getText());

        return view;
    }

    NotificationItem getNotification(int position) {
        return ((NotificationItem) getItem(position));
    }
}
