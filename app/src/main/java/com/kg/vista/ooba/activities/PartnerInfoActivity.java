package com.kg.vista.ooba.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Picasso;


public class PartnerInfoActivity extends AppCompatActivity {

    private String clientId;
    private String seller;
    private String statusText;
    private String picUrl;
    private String quantity;
    private int goodsPrice;
    private int amount;
    private double bonusAmount;
    private String promoCode;

    private TextView clientIdTextView;
    private TextView sellerTextView;
    private TextView statusTextTextView;
    private ImageView picUrlImageView;
    private TextView quantityTextView;
    private TextView goodPriceTextView;
    private TextView amountTextView;
    private TextView bonusAmountTextView;
    private TextView promoCodeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_info);

        getSupportActionBar().setTitle(R.string.partnerProgram);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clientIdTextView = (TextView) findViewById(R.id.clientInfo);
        sellerTextView = (TextView) findViewById(R.id.seller);
        statusTextTextView = (TextView) findViewById(R.id.status);
        picUrlImageView = (ImageView) findViewById(R.id.partnerImage);
        quantityTextView = (TextView) findViewById(R.id.quantity);
        goodPriceTextView = (TextView) findViewById(R.id.goods_price);
        amountTextView = (TextView) findViewById(R.id.amount);
        bonusAmountTextView = (TextView) findViewById(R.id.bonus);
        promoCodeTextView = (TextView) findViewById(R.id.promoCodeInfo);

        clientId = getIntent().getExtras().getString("clientId");
        seller = getIntent().getExtras().getString("seller");
        statusText = getIntent().getExtras().getString("statusText");
        picUrl = getIntent().getExtras().getString("picUrl");
        quantity = getIntent().getExtras().getString("quantity");
        goodsPrice = getIntent().getExtras().getInt("goodPrice");
        amount = getIntent().getExtras().getInt("amount");
        bonusAmount = getIntent().getExtras().getDouble("bonusAmount");
        promoCode = getIntent().getExtras().getString("promoCode");

        Picasso.with(this).load(picUrl).into(picUrlImageView);

        clientIdTextView.setText(clientId);
        sellerTextView.setText(seller);
        statusTextTextView.setText(statusText);
        quantityTextView.setText(quantity);
        goodPriceTextView.setText(String.valueOf(goodsPrice));
        amountTextView.setText(String.valueOf(amount));
        bonusAmountTextView.setText(String.valueOf(bonusAmount));
        promoCodeTextView.setText(promoCode);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
