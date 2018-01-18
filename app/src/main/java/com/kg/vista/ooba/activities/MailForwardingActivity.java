package com.kg.vista.ooba.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapters.MailForwardingAdapter;
import com.kg.vista.ooba.model.Item.MailForwardingItem;
import com.kg.vista.ooba.model.body.MFBody;
import com.kg.vista.ooba.model.body.MFListBody;
import com.kg.vista.ooba.model.dto.MFListDTO;
import com.kg.vista.ooba.utils.StaticGridView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MailForwardingActivity extends AppCompatActivity {

    private EditText trNum;
    private EditText rekvizityEditText;
    private ArrayList<MailForwardingItem> mailForwardings = new ArrayList<>();
    private List<String> goodType;
    private MailForwardingAdapter mailForwardingAdapter;
    private ArrayAdapter<String> goodTypeAdapter;
    private StaticGridView grvMailForwarding;
    private ImageButton addBtn;
    private Button saveBtn;
    private String text;
    private String trackNumber;
    private Spinner spinnerGoodType;
    private String ID;
    private String url;
    private MFListBody tracks = new MFListBody();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_forwarding);

        getSupportActionBar().setTitle(R.string.mailForwarding);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        trNum = (EditText) findViewById(R.id.edit_trek_number);
        spinnerGoodType = (Spinner) findViewById(R.id.spinner_good_type);
        addBtn = (ImageButton) findViewById(R.id.add_rekvizit);
        grvMailForwarding = (StaticGridView) findViewById(R.id.grvMailForwarding);
        saveBtn = (Button) findViewById(R.id.save_rekvizit);
        rekvizityEditText = (EditText) findViewById(R.id.edit_rekvizity);

        goodType = new ArrayList<>();

        url = "mf";
        ID = UsersManagement.getUserData(this);
        App.api().mf(url, ID).enqueue(new Callback<MFListDTO>() {
            @Override
            public void onResponse(Call<MFListDTO> call, Response<MFListDTO> response) {

                MFListDTO mfListDTO = response.body();
                for (String item : mfListDTO.getGoodTypes()) {
                    goodType.add(item);
                }
                goodTypeAdapter = new ArrayAdapter<>(MailForwardingActivity.this, android.R.layout.simple_spinner_item, goodType);
                goodTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinnerGoodType.setAdapter(goodTypeAdapter);

                rekvizityEditText.setText(mfListDTO.getRequisites());
            }

            @Override
            public void onFailure(Call<MFListDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        mailForwardingAdapter = new MailForwardingAdapter(this, mailForwardings);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trackNumber = trNum.getText().toString();
                if (!trackNumber.isEmpty()) {
                    text = spinnerGoodType.getSelectedItem().toString();
                    mailForwardings.add(new MailForwardingItem(trackNumber, text));
                    grvMailForwarding.setAdapter(mailForwardingAdapter);
                    //tracks.setMf(new MFBody(trackNumber,text));
                    tracks.addMFBody(new MFBody(trackNumber,text));
                    trNum.setText("");
                } else
                    Toast.makeText(getApplicationContext(), "Заполните трек номер", Toast.LENGTH_LONG).show();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MailForwardingInfoActivity.class);
                intent.putExtra("tracks", tracks);
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
