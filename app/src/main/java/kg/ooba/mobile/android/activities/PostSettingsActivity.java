package kg.ooba.mobile.android.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.adapters.PostSettingsAdapter;
import kg.ooba.mobile.android.model.Item.AddressItem;
import kg.ooba.mobile.android.model.dto.AddAddressDTO;
import kg.ooba.mobile.android.model.dto.AddressDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostSettingsActivity extends AppCompatActivity {

    private String[] country = {"Кыргызстан"};

    private Button addBtn;
    private ImageButton newAddBtn;

    private List<AddressItem> addressItems = new ArrayList<>();
    private PostSettingsAdapter postSettingsAdapter;
    private Spinner spinnerCountry;
    private Spinner spinnerRegion;
    private Spinner spinnerCity;
    private ArrayAdapter<String> countryAdapter;
    private ArrayAdapter<String> regionAdapter;
    private ArrayAdapter<String> cityAdapter;
    private List<String> regionList;
    private List<String> cityList;
    private int position;
    private ListView lvPost;
    private ViewFlipper viewFlipper;
    private EditText userName;
    private EditText userContact;
    private EditText userPhnum;

    private String url;
    private String ID;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_settings);

        getSupportActionBar().setTitle(R.string.post_settings);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;
        ID = UsersManagement.getUserData(context);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        newAddBtn = (ImageButton) findViewById(R.id.add_address);
        addBtn = (Button) findViewById(R.id.add_post);
        spinnerCountry = (Spinner) findViewById(R.id.spinner_country);
        spinnerRegion = (Spinner) findViewById(R.id.spinner_region);
        spinnerCity = (Spinner) findViewById(R.id.spinner_city);
        userName = (EditText) findViewById(R.id.user_name);
        userContact = (EditText) findViewById(R.id.contact_address);
        userPhnum = (EditText) findViewById(R.id.phone_num);
        lvPost = (ListView) findViewById(R.id.lvPost);

        countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, country);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryAdapter);

        regionList = new ArrayList<>();

        regionList.add("Чүй");
        regionList.add("Нарын");
        regionList.add("Талас");
        regionList.add("Ысык-көл");
        regionList.add("Ош");
        regionList.add("Жалал-Абад");
        regionList.add("Баткен");

        regionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, regionList);
        regionAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerRegion.setAdapter(regionAdapter);

        spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                position = arg2;
                add();
            }

            private void add() {
                switch (position) {
                    case 0:
                        cityList = new ArrayList<>();
                        cityList.add("Нарын");
                        select();
                        break;
                    case 1:
                        cityList = new ArrayList<>();
                        cityList.add("Бишкек");
                        cityList.add("Токмок");
                        cityList.add("Кара-балта");
                        cityList.add("Кант");
                        cityList.add("Кемин");
                        cityList.add("Каинда");
                        cityList.add("Орловка");
                        cityList.add("Шопоков");
                        select();
                        break;
                    case 2:
                        cityList = new ArrayList<>();
                        cityList.add("Талас");
                        select();
                        break;
                    case 3:
                        cityList = new ArrayList<>();
                        cityList.add("Балыкчы");
                        cityList.add("Чолпон-ата");
                        cityList.add("Каракол");
                        select();
                        break;
                    case 4:
                        cityList = new ArrayList<>();
                        cityList.add("Ош");
                        cityList.add("Ноокат");
                        cityList.add("Кара-суу");
                        cityList.add("Узген");
                        select();
                        break;
                    case 5:
                        cityList = new ArrayList<>();
                        cityList.add("Жалал-Абад");
                        cityList.add("Кара-көл");
                        cityList.add("Майлуу-суу");
                        cityList.add("Таш-көмүр");
                        cityList.add("Кербен");
                        cityList.add("Кочкор-ата");
                        cityList.add("Көк-жаңгак");
                        cityList.add("Токтогул");
                        select();
                        break;
                    case 6:
                        cityList = new ArrayList<>();
                        cityList.add("Айдаркен");
                        cityList.add("Баткен");
                        cityList.add("Исфана");
                        cityList.add("Кадамжай");
                        cityList.add("Сүлүктү");
                        cityList.add("Кызыл-кыя");
                        select();
                        break;
                }
            }

            private void select() {
                cityAdapter = new ArrayAdapter<>(PostSettingsActivity.this, android.R.layout.simple_dropdown_item_1line, cityList);
                cityAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinnerCity.setAdapter(cityAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Animation animationFlipIn = AnimationUtils.loadAnimation(this, R.anim.flipin);
        Animation animationFlipOut = AnimationUtils.loadAnimation(this, R.anim.flipout);
        viewFlipper.setInAnimation(animationFlipIn);
        viewFlipper.setOutAnimation(animationFlipOut);
        newAddBtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                viewFlipper.showNext();
            }
        });

        addBtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = userName.getText().toString();
                String contact = userContact.getText().toString();
                String phoneNum = userPhnum.getText().toString();

                addressItems.clear();
                addData(ID, name, contact, phoneNum);

                userName.setText("");
                userContact.setText("");
                userPhnum.setText("");
                viewFlipper.showPrevious();
            }
        });
        showData();
        postSettingsAdapter = new PostSettingsAdapter(this, addressItems, ID);
        lvPost.setAdapter(postSettingsAdapter);
    }

    public void addData(String ID, String name, String contact, String phoneNum) {
        url = "profile/address/add";
        App.api().addAddress(url, ID, name, contact, phoneNum).enqueue(new Callback<AddAddressDTO>() {
            @Override
            public void onResponse(Call<AddAddressDTO> call, Response<AddAddressDTO> response) {
                postSettingsAdapter.notifyDataSetChanged();
                int sql = response.body().getSql();
                int fio = response.body().getFio();
                int address = response.body().getAddress();
                int mobile_phone = response.body().getMobile_phone();


                if (sql == 1) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                } else if (sql == 0) {
                    if (fio == 1 || address == 1 || mobile_phone == 1) {
                        Toast.makeText(getApplicationContext(), "Не корректно заполнили поля", Toast.LENGTH_LONG).show();
                        viewFlipper.showNext();
                    }
                } else
                    Toast.makeText(getApplicationContext(), "Адрес успешно добавлен", Toast.LENGTH_LONG).show();
                showData();
            }

            @Override
            public void onFailure(Call<AddAddressDTO> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showData() {
        url = "profile/address";

        App.api().address(url, ID).enqueue(new Callback<List<AddressDTO>>() {
            @Override
            public void onResponse(Call<List<AddressDTO>> call, Response<List<AddressDTO>> response) {
                postSettingsAdapter.notifyDataSetChanged();
                List<AddressDTO> addressDTO = response.body();
                for (int i = 0; i < addressDTO.size(); i++) {

                    addressItems.add(AddressItem.of(addressDTO.get(i)));
                }
//                postSettingsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AddressDTO>> call, Throwable t) {
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
