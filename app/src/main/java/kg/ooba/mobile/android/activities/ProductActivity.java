package kg.ooba.mobile.android.activities;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.adapters.OtherProductsOfSellerRVAdapter;
import kg.ooba.mobile.android.adapters.ProductImageViewPagerAdapter;
import kg.ooba.mobile.android.adapters.ShopRecyclerViewAdapter;
import kg.ooba.mobile.android.model.Itemlist;
import kg.ooba.mobile.android.model.OtherProductsOfSeller;
import kg.ooba.mobile.android.model.Picture;
import kg.ooba.mobile.android.model.Product;
import kg.ooba.mobile.android.model.ProductConfig;
import kg.ooba.mobile.android.model.Property;
import kg.ooba.mobile.android.model.Specification;
import kg.ooba.mobile.android.model.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    private String productUrl;
    private String goodsId;
    private String goodsPicUrl;
    private String goodsName;
    private String goodsPrice;

    private TextView goodsTitle;
    private TextView tvGoodsPrice;
    private TextView tvGoodsQuantity;
    private TextView tvArtikul;
    private TextView tvSeller, tvProductLocation;
    private LinearLayout propertiesListView;
    //

    private List<String> imageUrlList;
    private ViewPager viewPager;
    private RecyclerView otherProductsRecView;
    private OtherProductsOfSellerRVAdapter otherProductsRecViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product1);

        //
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), "EXTRA_IMAGE");

        //CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //collapsingToolbarLayout.setTitle("");
        //collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        imageUrlList = new ArrayList<>();
        viewPager = (ViewPager) findViewById(R.id.productViewPager);

        initToolbar();
        otherProductsRecView = (RecyclerView) findViewById(R.id.recycler_view_other_products);
        propertiesListView = (LinearLayout) findViewById(R.id.properties);
        tvGoodsPrice = (TextView) findViewById(R.id.goods_price);
        //goodsImage = (ImageView) findViewById(R.id.goods_image);
        goodsTitle = (TextView) findViewById(R.id.goods_name);
        tvGoodsQuantity = (TextView) findViewById(R.id.product_quantity);
        tvArtikul = (TextView) findViewById(R.id.artikul);
        tvSeller = (TextView) findViewById(R.id.tv_seller);
        tvProductLocation = (TextView) findViewById(R.id.tv_product_location);

        productUrl = getIntent().getStringExtra("product_url").substring(1);
        String goodsArtikul = getIntent().getStringExtra("goods_id");
        goodsId = "product/config/"+ goodsArtikul;
        goodsPicUrl = getIntent().getStringExtra("goods_pic_url");
        goodsName = getIntent().getStringExtra("goods_name");
        goodsPrice = getIntent().getStringExtra("goods_price");
        String goodsQuantity = getIntent().getStringExtra("goods_quantity");

        goodsTitle.setText(goodsName);
        tvGoodsPrice.setText(goodsPrice);
        tvArtikul.append(goodsArtikul);
        tvGoodsQuantity.append(goodsQuantity);


        App.api().getProduct(productUrl).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Log.d("product_activity", "name "+response.body().getGoodsName());
                Log.d("product_activity", "GoodsId "+response.body().getGoodsId());
                Product product = response.body();
                String sellerName = product.getSeller();

                setOtherProducts(sellerName);

                tvSeller.append(sellerName);
                tvProductLocation.append(product.getLocation());
                List<Picture> pictureList = response.body().getPictures();
                for (Picture picture: pictureList){
                    picture.getImgUrl();
                    imageUrlList.add(picture.getImgUrl());
                }
                ProductImageViewPagerAdapter imageViewPagerAdapter =
                        new ProductImageViewPagerAdapter(ProductActivity.this, imageUrlList);
                viewPager.setAdapter(imageViewPagerAdapter);
                viewPager.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
        App.api().getProductConfig(goodsId).enqueue(new Callback<ProductConfig>() {
            @Override
            public void onResponse(Call<ProductConfig> call, Response<ProductConfig> response) {
                Log.d("product_activity", "goodId "+goodsId);

                List<Property> propertyList = response.body().getProperties();
                List<Specification> specificationList = response.body().getSpecification();
                for (Specification specification: specificationList){
                    List<Value> valueList = specification.getValues();
                    for (Value value: valueList){
                        String imgUrl = value.getImg();
                        String itemId = value.getId();
                        String label = value.getLabel();
                    }
                }

                TextView textViewKey;
                TextView textViewValue;
                LinearLayout linearLayout;
                for (Property property: propertyList){
                    String key = property.getValue();

                    StringBuffer value = new StringBuffer();
                    for (String str: property.getChild()){
                        value.append(str.trim());
                        value.append("\n");
                    }

                    linearLayout = new LinearLayout(ProductActivity.this);
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    textViewKey = new TextView(ProductActivity.this);
                    //textViewKey.setPadding(5, 5, 5, 5);
                    textViewKey.setTextColor(Color.parseColor("#009688"));
                    textViewKey.setText(key);
                    textViewValue = new TextView(ProductActivity.this);
                    LinearLayout.LayoutParams linearLayoutParams =
                            new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    linearLayoutParams.setMargins(0, 0, 0, 0);
                    textViewValue.setLayoutParams(linearLayoutParams);
                    textViewValue.setGravity(Gravity.END);

                    textViewValue.setText(value);
                    linearLayout.addView(textViewKey);
                    linearLayout.addView(textViewValue);
                    propertiesListView.addView(linearLayout);

                }
                int length = response.body().getConfig().keySet().toArray().length;

                for (int i=0; i<length; i++){
                    Object[] objects = response.body().getConfig().keySet().toArray();
                    Log.d("product_activity", "key "+objects[i].toString());
                    Log.d("product_activity", " "+response.body().getConfig().get(objects[i].toString()).getQuantity());
                }
            }

            @Override
            public void onFailure(Call<ProductConfig> call, Throwable t) {
                Log.d("product_activity", "failure "+t.getMessage());
            }
        });



    }
    public void setProductPrice(){

    }
    private void setOtherProducts(String sellerName){
        if(!sellerName.isEmpty()){
            Log.d("product_activity", "seller is not empty "+sellerName);

            App.api().getOtherProductsOfSeller("product/seller/"+sellerName).enqueue(new Callback<OtherProductsOfSeller>() {
                @Override
                public void onResponse(Call<OtherProductsOfSeller> call, Response<OtherProductsOfSeller> response) {
                    List<Itemlist> itemlist = response.body().getItemlist();
                    Log.d("product_activity", "got response ");
                    for (Itemlist item: itemlist){
                        Log.d("product_activity", "other products "+item.getPicUrl());

                    }
                    final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
                    layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
                    otherProductsRecViewAdapter = new OtherProductsOfSellerRVAdapter(ProductActivity.this, itemlist);
                    otherProductsRecView.setLayoutManager(layoutManager);
                    otherProductsRecView.setHasFixedSize(true);
                    otherProductsRecView.setAdapter(otherProductsRecViewAdapter);
                    otherProductsRecView.addOnScrollListener(new CenterScrollListener());
                }
                @Override
                public void onFailure(Call<OtherProductsOfSeller> call, Throwable t) {
                    Log.d("product_activity", "something went wrong "+t.getMessage());
                }
            });
        }
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            //actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        }
    }
}
