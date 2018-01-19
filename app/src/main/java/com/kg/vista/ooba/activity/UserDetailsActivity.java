package com.kg.vista.ooba.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.kg.vista.ooba.model.dto.UpdateDataDTO;
import com.kg.vista.ooba.model.dto.UserListDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends AbstractActivity {

    private EditText userName;
    private EditText passport;
    private EditText dateBirth;
    private TextView userEmail;
    private EditText phoneNumber;
    private TextView userBalance;
    private TextView userBill;
    private TextView userRegTime;
    private ImageView userImg;
    private Context context;

    private Button saveBtn;
    private RadioGroup genderRadioGroup;
    private RadioButton genderNone;
    private RadioButton genderFemale;
    private RadioButton genderMale;

    private Calendar date = Calendar.getInstance();

    private String ID;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        getSupportActionBar().setTitle(R.string.data);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        saveBtn = (Button) findViewById(R.id.save_data);

        context = this;
        ID = UsersManagement.getUserData(context);

        userName = (EditText) findViewById(R.id.edit_user_name);
        passport = (EditText) findViewById(R.id.edit_passport);
        dateBirth = (EditText) findViewById(R.id.edit_birth_date);
        userEmail = (TextView) findViewById(R.id.email);
        phoneNumber = (EditText) findViewById(R.id.edit_phone_num);
        genderNone = (RadioButton) findViewById(R.id.none);
        genderFemale = (RadioButton) findViewById(R.id.gender_female);
        genderMale = (RadioButton) findViewById(R.id.gender_male);
        userBalance = (TextView) findViewById(R.id.profileBalance);
        userBill = (TextView) findViewById(R.id.profileBill);
        userRegTime = (TextView) findViewById(R.id.profileReg);
        userImg = (ImageView) findViewById(R.id.profileImage);
        genderRadioGroup = (RadioGroup) findViewById(R.id.genderRadio);

        dateBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate(view);
            }
        });

        getData();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String fio = userName.getText().toString().trim();
                String idcard = passport.getText().toString().trim();
                String mobile_phone = phoneNumber.getText().toString().trim();
                String birthday = dateBirth.getText().toString().trim();
                int radioButtonID = genderRadioGroup.getCheckedRadioButtonId();
                View radioButton = genderRadioGroup.findViewById(radioButtonID);
                int sex = genderRadioGroup.indexOfChild(radioButton);
                setData(ID, fio, idcard, sex, birthday, mobile_phone);
            }
        });

    }

    public void setData(String ID, String fio, String idcard, int sex, String birthday, String mobile_phone) {
        url = "profile/update";
        App.api().updateUser(url, ID, fio, idcard, sex, birthday, mobile_phone).enqueue(new Callback<UpdateDataDTO>() {
            @Override
            public void onResponse(Call<UpdateDataDTO> call, Response<UpdateDataDTO> response) {
                int sql = response.body().getSql();

                if (sql == 0)
                    Toast.makeText(getApplicationContext(), "Данные успешно сохранились", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();

                getData();
            }

            @Override
            public void onFailure(Call<UpdateDataDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getData() {
        url = "profile";
        App.api().user(url, ID).enqueue(new Callback<UserListDTO>() {
            @Override
            public void onResponse(Call<UserListDTO> call, Response<UserListDTO> response) {

                String name = response.body().getUser().getFio();
                String email = response.body().getUser().getEmail();
                String idcard = response.body().getUser().getIdcard();
                int sex = response.body().getUser().getSex();
                String birthday = response.body().getUser().getBirthdate();
                String mobilePhone = response.body().getUser().getMobile_phone();
                float balance = response.body().getUser().getBalance();
                String bill = response.body().getUser().getBill();
                String regTime = response.body().getUser().getAgotime();
                String img = response.body().getUser().getImg();

                userName.setText(name);
                passport.setText(idcard);
                dateBirth.setText(birthday);
                userEmail.setText(email);
                phoneNumber.setText(mobilePhone);
                userBalance.setText(String.valueOf(balance));
                userBill.setText(bill);
                userRegTime.setText(regTime);
                if(img!="")
                    Picasso.with(context).load(img).into(userImg);


                if (sex == 0)
                    genderNone.setChecked(true);
                else if (sex == 1)
                    genderMale.setChecked(true);
                else
                    genderFemale.setChecked(true);
            }

            @Override
            public void onFailure(Call<UserListDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setDate(View v) {
        new DatePickerDialog(UserDetailsActivity.this, d,
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    private void setInitialDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format.format(date.getTime());
        dateBirth.setText(formatted);
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            date.set(Calendar.YEAR, year);
            date.set(Calendar.MONTH, monthOfYear);
            date.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDate();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
