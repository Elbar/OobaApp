package com.kg.vista.ooba.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.BasketAdapter;
import com.kg.vista.ooba.model.Item.BasketItem;
import com.kg.vista.ooba.model.dto.BasketListDTO;
import com.kg.vista.ooba.model.dto.CartDTO;
import com.kg.vista.ooba.model.dto.ClearBasketDTO;
import com.kg.vista.ooba.model.dto.GoodItemDTO;
import com.kg.vista.ooba.util.Country;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopActivity extends AbstractActivity {

    boolean enabledChina = true;
    boolean enabledUsa = false;
    private Button btnUsa;
    private Button btnChina;

    private List<BasketItem> basketItems = new ArrayList<>();
    private BasketAdapter basketAdapter;
    private TextView total;
    private ListView lvBasket;
    private ImageButton clearImageButton;
    private Button orderGoodBtn;

    private String url;
    private String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        Toolbar toolbar = (Toolbar) findViewById(R.id.shop_toolbar);
        btnChina = (Button) findViewById(R.id.btnChina);
        btnUsa = (Button) findViewById(R.id.btnUsa);
        lvBasket = (ListView) findViewById(R.id.lvBasket);
        total = (TextView) findViewById(R.id.resultSum);
        clearImageButton = (ImageButton) findViewById(R.id.clear);
        orderGoodBtn = (Button) findViewById(R.id.basketBtn);

        toolbar.setTitle(R.string.basketItem);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnChina.setBackgroundResource(R.drawable.togglebutton);

        btnChina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChina.setBackgroundResource(R.drawable.togglebutton);
                btnUsa.setBackgroundResource(R.drawable.toggle_button_black);
                enabledChina = true;
                enabledUsa = false;
                basketItems.clear();
                data(Country.CHINA.getCode());
            }
        });
        btnUsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnUsa.setBackgroundResource(R.drawable.togglebutton);
                btnChina.setBackgroundResource(R.drawable.toggle_button_black);
                enabledChina = false;
                enabledUsa = true;
                basketItems.clear();
                data(Country.USA.getCode());
            }
        });

        ID = UsersManagement.getUserData(this);

        clearImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (enabledChina)
                    clearData(Country.CHINA.getCode());
                else
                    clearData(Country.USA.getCode());
            }
        });

        orderGoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopActivity.this, BasketOrderActivity.class);
                if (enabledChina)
                    intent.putExtra("geo", Country.CHINA.getCode());
                else
                    intent.putExtra("geo", Country.USA.getCode());
                startActivity(intent);
            }
        });

        basketItems.clear();
        data(Country.CHINA.getCode());
        basketAdapter = new BasketAdapter(this, basketItems);
        lvBasket.setAdapter(basketAdapter);
    }

    public String geo() {
        if (enabledChina)
            return Country.CHINA.getCode();
        else
            return Country.USA.getCode();
    }

    void clearData(String geo) {
        url = "clearcart";
        App.api().clearBasket(url, ID, geo).enqueue(new Callback<ClearBasketDTO>() {
            @Override
            public void onResponse(Call<ClearBasketDTO> call, Response<ClearBasketDTO> response) {
                basketAdapter.notifyDataSetChanged();
                int success = response.body().getSuccess();
                if (success == 1) {
                    basketItems.clear();
                    basketAdapter.notifyDataSetChanged();
                } else
                    Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ClearBasketDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void data(String geo) {
        url = "cart";
        App.api().basket(url, geo, ID).enqueue(new Callback<BasketListDTO>() {
            @Override
            public void onResponse(Call<BasketListDTO> call, Response<BasketListDTO> response) {
                basketAdapter.notifyDataSetChanged();
                BasketListDTO basketListDTO = response.body();
                if (basketListDTO == null || basketListDTO.getCart() == null) {
                    basketItems.clear();
                    return;
                }
                for (CartDTO cart : basketListDTO.getCart()) {
                    for (GoodItemDTO good : cart.getGoods())
                        basketItems.add(BasketItem.of(good));
                }
                int totalSum = response.body().getTotal();
                total.setText(String.valueOf(totalSum));
            }

            @Override
            public void onFailure(Call<BasketListDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
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
