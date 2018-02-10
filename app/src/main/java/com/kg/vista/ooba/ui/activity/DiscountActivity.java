package com.kg.vista.ooba.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.adapter.ProductRVAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiscountActivity extends AbstractActivity {
    ProductRVAdapter mAdapter;
    @BindView(R.id.product_rv)
    RecyclerView mProductRV;
    private String TAG = "ProductActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        ButterKnife.bind(this);

//        mAdapter = new ProductRVAdapter();
//        mAdapter.setHasStableIds(true);
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

//        mProductRV.setAdapter(mAdapter);
//        getProducts();


    }

//    private void getProducts() {
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        final RetrofitService request = retrofit.create(RetrofitService.class);
//
//        Call<ProductList> getExecutorProfile = request.getProductByIndex();
//
//        getExecutorProfile.enqueue(new Callback<ProductList>() {
//            @Override
//            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
//                try {
//                    List<Product2> product = response.body().getProduct();
//                    List<Product2> productItem = new ArrayList<>();
//
//                    for (int i = 0; i < product.size(); i++) {
//                        Log.e(TAG, product.get(i).getImages());
//                        Product2 product2 = new Product2();
//                        product2.setImages(product.get(i).getImages());
//                        product2.setPrice(product.get(i).getPrice());
//                        product2.setNickTitle(product.get(i).getNickTitle());
//                        product2.setUrlProduct(product.get(i).getUrlProduct());
//                        productItem.add(product2);
//
//                    }
//
//                    mAdapter.setItems(productItem);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ProductList> call, Throwable t) {
//
//            }
//        });
//
//    }

}
