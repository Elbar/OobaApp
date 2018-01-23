package com.kg.vista.ooba.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.GridView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.CatalogGVAdapter;
import com.kg.vista.ooba.api.RetrofitService;
import com.kg.vista.ooba.model.Catalog;
import com.kg.vista.ooba.model.Catalog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kg.vista.ooba.api.conf.Config.BASE_URL;

public class CatalogActivity extends AbstractActivity {

    @BindView(R.id.grid_view_shop)
    GridView mGridViewShop;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        ButterKnife.bind(this);
        getShops();


    }

    private void getShops() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RetrofitService request = retrofit.create(RetrofitService.class);


        Call<List<Catalog>> getCatalog = request.getCatalog();

        getCatalog.enqueue(new Callback<List<Catalog>>() {
            @Override
            public void onResponse(@NonNull Call<List<Catalog>> call, @NonNull Response<List<Catalog>> response) {

                try {
                    List<Catalog> catalogs = response.body();
                    List<Catalog> catalogItem = new ArrayList<>();

                    for (int i = 0; i < catalogs.size(); i++) {
                        Catalog catalog = new Catalog();
                        catalog.setLinkLogo(catalogs.get(i).getLinkLogo());
                        catalogItem.add(catalog);

                    }

//                    CatalogRVAdapter = new CatalogGVAdapter(catalogItem);
//                    mCatalogRV.setLayoutManager(CatalogLinearLayoutManager);
//                    mCatalogRV.setAdapter(CatalogRVAdapter);

                    CatalogGVAdapter adapter = new CatalogGVAdapter(CatalogActivity.this, catalogItem);
                    mGridViewShop.setAdapter(adapter);


                } catch (Exception e) {
                    e.printStackTrace();

                }
            }


            @Override
            public void onFailure(Call<List<Catalog>> call, Throwable t) {

            }
        });

    }

}
