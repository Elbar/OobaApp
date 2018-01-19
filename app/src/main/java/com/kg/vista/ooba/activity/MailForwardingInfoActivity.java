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
import com.kg.vista.ooba.adapter.ShippingOptionAdapter;
import com.kg.vista.ooba.model.Item.AddressItem;
import com.kg.vista.ooba.model.Item.ShippingItem;
import com.kg.vista.ooba.model.body.MFBody;
import com.kg.vista.ooba.model.body.MFListBody;
import com.kg.vista.ooba.model.dto.AddressDTO;
import com.kg.vista.ooba.model.dto.BasketListDTO;
import com.kg.vista.ooba.model.dto.MFSaveDTO;
import com.kg.vista.ooba.model.dto.ShippingDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MailForwardingInfoActivity extends AppCompatActivity {

    private Button saveBtn;

    private ArrayList<AddressItem> addressItem = new ArrayList<>();
    private AddressOptionAdapter addressOptionAdapter;

    private ArrayList<ShippingItem> shippingItem = new ArrayList<>();
    private ShippingOptionAdapter shippingOptionAdapter;

    private List<MFBody> mfBody = new ArrayList<>();

    private String url;
    private String ID;
    private String shippingID;
    private String addressID;
    private ListView lvAddressRadio;
    private ListView lvShippingRadio;
    private String geo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_forwarding_info);

        getSupportActionBar().setTitle(R.string.mailForwarding);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        saveBtn = (Button) findViewById(R.id.saveMData);
        lvAddressRadio = (ListView) findViewById(R.id.lvAddressRadio);
        lvShippingRadio = (ListView) findViewById(R.id.lvShippingRadio);


        ID = UsersManagement.getUserData(this);

        show();

        addressOptionAdapter = new AddressOptionAdapter(this, addressItem);
        lvAddressRadio.setAdapter(addressOptionAdapter);

        shippingOptionAdapter = new ShippingOptionAdapter(this, shippingItem);
        lvShippingRadio.setAdapter(shippingOptionAdapter);
//
//        for(int i=0;i<mfBody.size();i++) {
//            Toast.makeText(getApplicationContext(), mfBody.get(i).getTrackNumber(), Toast.LENGTH_LONG).show();
//            Toast.makeText(getApplicationContext(), mfBody.get(i).getType(), Toast.LENGTH_LONG).show();
//        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MFListBody body = new MFListBody();
                body.setUserId(ID);
                shippingID = shippingItem.get(shippingOptionAdapter.getPosition()).getShippingId();
                addressID = addressItem.get(addressOptionAdapter.getPosition()).getAddress_id();
                body.setAddressId(shippingID);
                body.setShippingId(addressID);
                body.setMf((List<MFBody>)(getIntent().getSerializableExtra("tracks")));
                setData(body);
            }
        });
    }

    private void setData(MFListBody body) {

        App.api().mfSave(body).enqueue(new Callback<MFSaveDTO>() {
            @Override
            public void onResponse(Call<MFSaveDTO> call, Response<MFSaveDTO> response) {
                int success = response.body().getSuccess();

                if (success == 1)
                    Toast.makeText(getApplicationContext(), "Заказ оформлен", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MFSaveDTO> call, Throwable t) {
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
