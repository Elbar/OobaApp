package com.kg.vista.ooba.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.body.RegistrationBody;
import com.kg.vista.ooba.model.dto.RegistrationDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AbstractActivity {

    private AutoCompleteTextView emailTextView;
    private EditText passwordEditText;
    private Button registrationBtn;

    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle(R.string.registr);

        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        emailTextView = (AutoCompleteTextView) findViewById(R.id.reg_email);
        passwordEditText = (EditText) findViewById(R.id.reg_password);
        registrationBtn = (Button) findViewById(R.id.registration_button);

        registrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = emailTextView.getText().toString().trim();
                password = passwordEditText.getText().toString().trim();

                RegistrationBody body = new RegistrationBody();
                body.setMail(email);
                body.setPass(password);

                App.api().registration(body).enqueue(new Callback<RegistrationDTO>() {
                    @Override
                    public void onResponse(Call<RegistrationDTO> call, Response<RegistrationDTO> response) {

                        int email = response.body().getLogin();
                        int password = response.body().getPassword();

                        if (email == 0 && password == 0) {
                            Toast.makeText(getApplicationContext(), "Регистрация прошла успешно", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else if (email == 1 && password == 0)
                            Toast.makeText(getApplicationContext(), "Вы не заполнили поле email", Toast.LENGTH_LONG).show();
                        else if (email == 2)
                            Toast.makeText(getApplicationContext(), "Неправильно ввели email", Toast.LENGTH_LONG).show();
                        else if (password == 1 && email == 0)
                            Toast.makeText(getApplicationContext(), "Вы не ввели пароль", Toast.LENGTH_LONG).show();
                        else if (password == 2)
                            Toast.makeText(getApplicationContext(), "Введите не меньше 6 символов", Toast.LENGTH_LONG).show();
                        else if (email == 3)
                            Toast.makeText(getApplicationContext(), "Такой логин существует", Toast.LENGTH_LONG).show();
                        else if (email == 1 && password == 1)
                            Toast.makeText(getApplicationContext(), "Вы не заполнили поля", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<RegistrationDTO> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
