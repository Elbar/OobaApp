package com.kg.vista.ooba.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.NotificationAdapter;
import com.kg.vista.ooba.model.Item.NotificationItem;
import com.kg.vista.ooba.model.dto.NotificationItemDTO;
import com.kg.vista.ooba.model.dto.NotificationListDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AbstractActivity {

    private ArrayList<NotificationItem> notifications = new ArrayList<>();
    private NotificationAdapter notificationAdapter;

    private GridView grvNotif;

    private String ID;
    private String url;
    private String limit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        getSupportActionBar().setTitle(R.string.notif);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        grvNotif = (GridView) findViewById(R.id.gvNotif);

        ID = UsersManagement.getUserData(this);

        grvNotif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                grvNotif.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });

        notificationAdapter = new NotificationAdapter(this, notifications);
        show();
    }

    private void show() {
        url = "notifications";
        limit = "all";
        App.api().notification(url, limit, ID).enqueue(new Callback<NotificationListDTO>() {
            @Override
            public void onResponse(Call<NotificationListDTO> call, Response<NotificationListDTO> response) {
                notificationAdapter.notifyDataSetChanged();
                NotificationListDTO notificationListDTO = response.body();
                if (notificationListDTO == null || notificationListDTO.getNotifications() == null) {
                    notifications.clear();
                    return;
                }
                for (NotificationItemDTO item : notificationListDTO.getNotifications()) {
                    notifications.add(NotificationItem.of(item));
                    String status = item.getIsShow();
                    if (status.equals("0"))
                        grvNotif.setBackgroundColor(getResources().getColor(R.color.white));
                }
            }

            @Override
            public void onFailure(Call<NotificationListDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        select();
    }

    private void select() {
        grvNotif.setAdapter(notificationAdapter);
        adjustGridView();
    }

    private void adjustGridView() {
        grvNotif.setVerticalSpacing(20);
        grvNotif.setHorizontalSpacing(20);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
