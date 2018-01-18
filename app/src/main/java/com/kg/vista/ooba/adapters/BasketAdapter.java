package com.kg.vista.ooba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kg.vista.ooba.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import com.kg.vista.ooba.activities.App;
import com.kg.vista.ooba.activities.ShopActivity;
import com.kg.vista.ooba.activities.UsersManagement;
import com.kg.vista.ooba.model.Item.BasketItem;
import com.kg.vista.ooba.model.dto.DeleteGoodDTO;
import com.kg.vista.ooba.model.dto.UpdateGoodDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class BasketAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater lInflater;
    private List<BasketItem> basketItems;
    private List<Integer> selectedPosition = new ArrayList<>();
    private List<String> goodsID = new ArrayList<>();

    private TextView counter;
    private TextView total;
    private ImageButton refreshBtn;
    private ImageButton deleteBtn;
    private ImageView decreaseItemCountBtn;
    private ImageView increaseItemCountBtn;
    private ImageView image;
    private CheckBox goodNum;

    private String setCount;
    private String setPrice;
    private String rec_id;
    private String url;
    private String comment;
    private String count;
    private String ID;

    public BasketAdapter(Context context, List<BasketItem> basketItem) {
        this.context = context;
        basketItems = basketItem;
        lInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return basketItems.size();
    }

    @Override
    public Object getItem(int position) {
        return basketItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.basket, parent, false);
        }

        final BasketItem b = getBasket(position);

        ((TextView) view.findViewById(R.id.basketCount)).setText(b.getCount());
        ((TextView) view.findViewById(R.id.attribute)).setText(b.getAttr());
        ((TextView) view.findViewById(R.id.comment)).setText(b.getComments());
        ((TextView) view.findViewById(R.id.price)).setText(b.getPrice());
        ((TextView) view.findViewById(R.id.basketTotal)).setText(String.valueOf(b.getTotal()));
        image = (ImageView) view.findViewById(R.id.basketImage);
        Picasso.with(context).load(b.getPicUrl()).into(image);

        deleteBtn = (ImageButton) view.findViewById(R.id.delete);
        refreshBtn = (ImageButton) view.findViewById(R.id.refresh);
        goodNum = (CheckBox) view.findViewById(R.id.cartCheckBox);
        increaseItemCountBtn = (ImageView) view.findViewById(R.id.increase_item_count);
        decreaseItemCountBtn = (ImageView) view.findViewById(R.id.decrease_item_count);

        ID = UsersManagement.getUserData(context);

        goodNum.setTag(0);
        goodNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition.add((Integer)view.getTag());
                notifyDataSetChanged();
            }
        });

//        for(int i=0;i<selectedPosition.size();i++){
//            BasketItem pos = selectedPosition.get(i);
//            Log.d("pos","pos "+pos);
//            String goodID = pos.getRecId();
//            goodsID.add(goodID);
//        }

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rec_id = b.getRecId();
                url = "updategood";
                comment = b.getComments();
                count = b.getCount();

                App.api().updateGood(url, rec_id, ID, comment, count).enqueue(new Callback<UpdateGoodDTO>() {
                    @Override
                    public void onResponse(Call<UpdateGoodDTO> call, Response<UpdateGoodDTO> response) {
                        int success = response.body().getSuccess();
                        if (success == 1) {
                            Toast.makeText(context.getApplicationContext(), comment, Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(context.getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
                        basketItems.clear();
                        notifyDataSetChanged();
                        String geo = ((ShopActivity) context).geo();
                        ((ShopActivity) context).data(geo);
                    }

                    @Override
                    public void onFailure(Call<UpdateGoodDTO> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(context.getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rec_id = b.getRecId();
                url = "deletecart";

                App.api().deleteGood(url, rec_id, ID).enqueue(new Callback<DeleteGoodDTO>() {
                    @Override
                    public void onResponse(Call<DeleteGoodDTO> call, Response<DeleteGoodDTO> response) {
                        int success = response.body().getSuccess();
                        if (success == 1) {
                            basketItems.remove(b);
                            notifyDataSetChanged();
                        } else
                            Toast.makeText(context.getApplicationContext(), "Произошла ошибка", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DeleteGoodDTO> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(context.getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        decreaseItemCountBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ViewGroup viewGroup = (ViewGroup) v.getParent();
                counter = (TextView) viewGroup.findViewById(R.id.basketCount);
                total = (TextView) viewGroup.findViewById(R.id.basketTotal);
                setCount = counter.getText().toString();
                counter.setText(String.valueOf(basketItems.get(position).decrease(setCount)));
                setCount = counter.getText().toString();
                setPrice = b.getPrice();
                total.setText(String.valueOf(basketItems.get(position).multiply(setCount, setPrice)));
            }
        });
        increaseItemCountBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ViewGroup viewGroup = (ViewGroup) v.getParent();
                counter = (TextView) viewGroup.findViewById(R.id.basketCount);
                total = (TextView) viewGroup.findViewById(R.id.basketTotal);
                setCount = counter.getText().toString();
                counter.setText(String.valueOf(basketItems.get(position).increase(setCount)));
                setCount = counter.getText().toString();
                setPrice = b.getPrice();
                total.setText(String.valueOf(basketItems.get(position).multiply(setCount, setPrice)));
            }
        });
        return view;
    }

    public List<String> getGoodsID(){
        return goodsID;
    }

    BasketItem getBasket(int position) {
        return ((BasketItem) getItem(position));
    }
}
