package com.kg.vista.ooba.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.BalanceAdapter;
import com.kg.vista.ooba.model.Item.BalanceItem;
import com.kg.vista.ooba.model.dto.BalanceDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BalanceActivity extends AbstractActivity {

    private ArrayList<BalanceItem> balanceItems = new ArrayList<>();
    private BalanceAdapter balanceAdapter;

    private GridView grvBalance;

    private String url;
    private String ID;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);

        getSupportActionBar().setTitle(R.string.balance);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        grvBalance = (GridView) findViewById(R.id.gvBalance);

        url="invoices";
        ID = UsersManagement.getUserData(this);
        type = "balance";

        balanceAdapter = new BalanceAdapter(this, balanceItems);
        show();
    }

    private void show() {
        App.api().balance(url, "12", type).enqueue(new Callback<List<BalanceDTO>>() {
            @Override
            public void onResponse(Call<List<BalanceDTO>> call, Response<List<BalanceDTO>> response) {

                List<BalanceDTO> balanceDTO = response.body();
                for (int i = 0; i < balanceDTO.size(); i++) {

                    balanceItems.add(BalanceItem.of(balanceDTO.get(i)));
                }
               balanceAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<BalanceDTO>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        select();
    }

    private void select() {
        grvBalance.setAdapter(balanceAdapter);
        adjustGridView();
    }

    private void adjustGridView() {
        grvBalance.setVerticalSpacing(20);
        grvBalance.setHorizontalSpacing(20);
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
