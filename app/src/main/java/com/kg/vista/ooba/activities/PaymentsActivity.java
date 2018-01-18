package com.kg.vista.ooba.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapters.PaymentsAdapter;
import com.kg.vista.ooba.model.Item.PaymentsItem;
import com.kg.vista.ooba.model.dto.PaymentsItemDTO;
import com.kg.vista.ooba.model.dto.PaymentsListDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentsActivity extends AppCompatActivity {

    private ArrayList<PaymentsItem> paymentsItems = new ArrayList<>();
    private PaymentsAdapter paymentsAdapter;

    private int status;
    private ListView lvPayments;

    private String ID;
    private String url;
    private String type;

    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvPayments = (ListView) findViewById(R.id.lvPayments);
        totalTextView = (TextView) findViewById(R.id.total);

        url="invoices";
        ID = UsersManagement.getUserData(this);

        paymentsAdapter = new PaymentsAdapter(this, paymentsItems);

//        lvPayments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String payDate = payments.get(i).getPaymentDate();
//                String payStatus = payments.get(i).getPaymentStatus();
//                String payTitle = payments.get(i).getPaymentTitle();
//                String accountNum = payments.get(i).getAccountNum();
//                String paySum = payments.get(i).getPaymentSum();
//                Intent intent = new Intent(view.getContext(), PaymentInfoActivity.class);
//                intent.putExtra("payDate", payDate);
//                intent.putExtra("payStatus", payStatus);
//                intent.putExtra("payTitle", payTitle);
//                intent.putExtra("accountNum", accountNum);
//                intent.putExtra("paySum", paySum);
//                startActivity(intent);
//            }
//        });

        status = getIntent().getExtras().getInt("status");
        switch (status) {
            case 0:
                getSupportActionBar().setTitle(R.string.payment_done);
                type = "paid";
                data(type);
                break;
            case 1:
                getSupportActionBar().setTitle(R.string.payment_yet);
                type = "unpaid";
                data(type);
                break;
        }
    }

    private void data(String type){
        App.api().payments(url, "12", type).enqueue(new Callback<PaymentsListDTO>() {
            @Override
            public void onResponse(Call<PaymentsListDTO> call, Response<PaymentsListDTO> response) {
                paymentsAdapter.notifyDataSetChanged();
                PaymentsListDTO paymentsListDTO=response.body();
                if (paymentsListDTO == null || paymentsListDTO.getList() == null) {
                    paymentsItems.clear();
                    return;
                }
                for (PaymentsItemDTO item : paymentsListDTO.getList()) {
                    paymentsItems.add(PaymentsItem.of(item));
                }
                int total = response.body().getTotal();
                totalTextView.setText(String .valueOf(total));
            }

            @Override
            public void onFailure(Call<PaymentsListDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        select();
    }

    private void select() {
        lvPayments.setAdapter(paymentsAdapter);
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
