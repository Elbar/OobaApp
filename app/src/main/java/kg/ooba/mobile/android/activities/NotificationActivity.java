package kg.ooba.mobile.android.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.adapters.NotificationAdapter;
import kg.ooba.mobile.android.model.Item.NotificationItem;
import kg.ooba.mobile.android.model.dto.NotificationItemDTO;
import kg.ooba.mobile.android.model.dto.NotificationListDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {

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
        App.api().notification(url,limit, ID).enqueue(new Callback<NotificationListDTO>() {
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
                    if(status.equals("0"))
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
