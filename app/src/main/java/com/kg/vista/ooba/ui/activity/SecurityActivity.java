package com.kg.vista.ooba.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.dto.SecurityDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecurityActivity extends AbstractActivity {

    private EditText oldPasswordEditText;
    private EditText newPasswordEditText;
    private EditText retryPasswordEditText;
    private String ID;
    private String url;
    private Button changeBtn;
    private String oldPassword;
    private String newPassword;
    private String retryPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

        getSupportActionBar().setTitle(R.string.privacy);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        oldPasswordEditText = (EditText) findViewById(R.id.edit_old_password);
        newPasswordEditText = (EditText) findViewById(R.id.edit_new_password);
        retryPasswordEditText = (EditText) findViewById(R.id.edit_repeat_password);
        changeBtn = (Button) findViewById(R.id.save);

        ID = UsersManagement.getUserData(this);
        url = "profile/pass";

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oldPassword = oldPasswordEditText.getText().toString().trim();
                newPassword = newPasswordEditText.getText().toString().trim();
                retryPassword = retryPasswordEditText.getText().toString().trim();

                App.api().security(url, ID, oldPassword, newPassword, retryPassword).enqueue(new Callback<SecurityDTO>() {
                    @Override
                    public void onResponse(Call<SecurityDTO> call, Response<SecurityDTO> response) {

                        int oldPassword = response.body().getPassword_old();
                        int newPassword = response.body().getPassword_new();
                        int retryPassword = response.body().getPassword_retry();
                        int sql = response.body().getSql();

                        if (oldPassword == 1)
                            Toast.makeText(getApplicationContext(), "Не верно ввели пароль", Toast.LENGTH_LONG).show();
                        else if (retryPassword == 3)
                            Toast.makeText(getApplicationContext(), "Пароли не совпадают или не ввели повторный пароль", Toast.LENGTH_LONG).show();
                        else if (sql == 0)
                            Toast.makeText(getApplicationContext(), "Пароль успешно сменен", Toast.LENGTH_LONG).show();
                        else {
                            if (newPassword == 1 && retryPassword == 3)
                                Toast.makeText(getApplicationContext(), "Не ввели новый пароль", Toast.LENGTH_LONG).show();
                            else if (newPassword == 2 && retryPassword == 3)
                                Toast.makeText(getApplicationContext(), "Введите не меньше 6 символов", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SecurityDTO> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
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
