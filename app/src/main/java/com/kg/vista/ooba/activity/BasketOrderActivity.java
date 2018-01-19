package com.kg.vista.ooba.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.AddressOptionAdapter;
import com.kg.vista.ooba.adapter.BasketAdapter;
import com.kg.vista.ooba.adapter.ShippingOptionAdapter;
import com.kg.vista.ooba.model.Item.AddressItem;
import com.kg.vista.ooba.model.Item.ShippingItem;
import com.kg.vista.ooba.model.dto.AddressDTO;
import com.kg.vista.ooba.model.dto.BasketListDTO;
import com.kg.vista.ooba.model.dto.OrderGoodDTO;
import com.kg.vista.ooba.model.dto.ShippingDTO;
import com.kg.vista.ooba.util.Country;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BasketOrderActivity extends AppCompatActivity {

    private ArrayList<AddressItem> addressItem = new ArrayList<>();
    private AddressOptionAdapter addressOptionAdapter;

    private ArrayList<ShippingItem> shippingItem = new ArrayList<>();
    private ShippingOptionAdapter shippingOptionAdapter;

    private BasketAdapter basketAdapter;

    private Button saveOrderBtn;

    private String url;
    private String shipping;
    private String address;
    private String ID;
    private ListView lvAddressRadio;
    private ListView lvShippingRadio;
    private String geo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_order);

        getSupportActionBar().setTitle(R.string.orderGood);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvAddressRadio = (ListView) findViewById(R.id.lvAddressRadio);
        lvShippingRadio = (ListView) findViewById(R.id.lvShippingRadio);
        saveOrderBtn = (Button) findViewById(R.id.saveMData);

        saveOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order();
            }
        });

        ID = UsersManagement.getUserData(this);
        geo = Country.CHINA.getCode();
        show();

        addressOptionAdapter = new AddressOptionAdapter(this, addressItem);
        lvAddressRadio.setAdapter(addressOptionAdapter);

        shippingOptionAdapter = new ShippingOptionAdapter(this, shippingItem);
        lvShippingRadio.setAdapter(shippingOptionAdapter);
    }

    private void order(){
        url = "ordergood";
        shipping = shippingItem.get(shippingOptionAdapter.getPosition()).getShippingId();
        address = addressItem.get(addressOptionAdapter.getPosition()).getAddress_id();
        String comment = "abcd";
        List<String> goods_id = new ArrayList<>();
        goods_id = basketAdapter.getGoodsID();
        App.api().orderGood(url, ID,address, shipping,goods_id, comment ).enqueue(new Callback<OrderGoodDTO>() {
            @Override
            public void onResponse(Call<OrderGoodDTO> call, Response<OrderGoodDTO> response) {
                Toast.makeText(getApplicationContext(), "Заказ успешно оформлен", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<OrderGoodDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    private void show() {
        url = "cart";
        App.api().basket(url, geo, ID).enqueue(new Callback<BasketListDTO>() {
            @Override
            public void onResponse(Call<BasketListDTO> call, Response<BasketListDTO> response) {
                addressOptionAdapter.notifyDataSetChanged();
                shippingOptionAdapter.notifyDataSetChanged();
                BasketListDTO basketListDTO = response.body();
                if (basketListDTO == null || basketListDTO.getAddress() == null) {
                    addressItem.clear();
                    return;
                }
                if (basketListDTO == null || basketListDTO.getShipping() == null) {
                    shippingItem.clear();
                    return;
                }
                for (AddressDTO addressDTO : basketListDTO.getAddress())
                    addressItem.add(AddressItem.of(addressDTO));

                for (ShippingDTO shippingDTO : basketListDTO.getShipping())
                    shippingItem.add(ShippingItem.of(shippingDTO));
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
