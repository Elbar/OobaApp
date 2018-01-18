package kg.ooba.mobile.android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.model.dto.PaymentsStatusDTO;
import kg.ooba.mobile.android.model.dto.UpdateAddressDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentsStatusActivity extends AppCompatActivity {

    private RelativeLayout payDone;
    private RelativeLayout payYet;
    private LinearLayout payBalance;

    private String ID;
    private String url;

    private int done;
    private int yet;

    private TextView doneCount;
    private TextView yetCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_status);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        payDone = (RelativeLayout) findViewById(R.id.done);
        payYet = (RelativeLayout) findViewById(R.id.yet);
        payBalance = (LinearLayout) findViewById(R.id.balance);
        doneCount = (TextView) findViewById(R.id.doneCount);
        yetCount = (TextView) findViewById(R.id.yetCount);

        ID = UsersManagement.getUserData(this);
        url = "invoices/statuses_info";

        App.api().status(url, "12").enqueue(new Callback<PaymentsStatusDTO>() {
            @Override
            public void onResponse(Call<PaymentsStatusDTO> call, Response<PaymentsStatusDTO> response) {
                done = response.body().getPaid();
                yet = response.body().getUnpaid();

                doneCount.setText(String.valueOf(done));
                yetCount.setText(String.valueOf(yet));
            }

            @Override
            public void onFailure(Call<PaymentsStatusDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        payDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaymentsActivity.class);
                intent.putExtra("status", 0);
                startActivity(intent);
            }
        });

        payYet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaymentsActivity.class);
                intent.putExtra("status", 1);
                startActivity(intent);
            }
        });

        payBalance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BalanceActivity.class);
                startActivity(intent);
            }
        });
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
