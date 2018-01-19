package com.kg.vista.ooba.activity;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Picasso;


public class GroupInfoActivity extends AppCompatActivity {

    private String goodTitle;
    private String oldCost;
    private String newCost;
    private String image;
    private String goodId;
    private String statusId;

    private TextView groupDesc;
    private TextView oldInfo;
    private TextView newInfo;
    private ImageView imageInfo;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        groupDesc = (TextView) findViewById(R.id.groupDesc);
        oldInfo = (TextView) findViewById(R.id.oldInfo);
        newInfo = (TextView) findViewById(R.id.newInfo);
        imageInfo = (ImageView) findViewById(R.id.imageInfo);
        status = (TextView) findViewById(R.id.status);

        statusId = getIntent().getExtras().getString("status");
        status.setText(statusId);

        goodTitle = getIntent().getExtras().getString("goodTitle");
        groupDesc.setText(goodTitle);

        oldCost = getIntent().getExtras().getString("oldCost");
        oldInfo.setText(oldCost);
        oldInfo.setPaintFlags(oldInfo.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

//        newCost = getIntent().getExtras().getString("newCost");
//        newInfo.setText(newCost);

        goodId = getIntent().getExtras().getString("articul");
        getSupportActionBar().setTitle(goodId);

        image = getIntent().getExtras().getString("image");
        Picasso.with(this).load(image).into(imageInfo);
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
