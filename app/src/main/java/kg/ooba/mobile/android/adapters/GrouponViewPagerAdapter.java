package kg.ooba.mobile.android.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.activities.ProductActivity;
import kg.ooba.mobile.android.activities.ProductCartActivity;
import kg.ooba.mobile.android.model.Groupon;


public class GrouponViewPagerAdapter extends PagerAdapter {

    Context context;
    List<Groupon> grouponList;
    LayoutInflater inflater;

    public GrouponViewPagerAdapter(Context context, List<Groupon> grouponList){
        this.context = context;
        this.grouponList = grouponList;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return grouponList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = inflater.inflate(R.layout.groupon_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.thumbnail);
        TextView tvTitle = (TextView) itemView.findViewById(R.id.title);
        TextView tvPrice = (TextView) itemView.findViewById(R.id.price);
        TextView tvPriceTotal = (TextView) itemView.findViewById(R.id.price_total);
        //TextView tvDescription = itemView.findViewById(R.id.html);
        final ProgressBar progressBar = (ProgressBar) itemView.findViewById(R.id.grouponProgressBar);

        final Groupon groupon = grouponList.get(position);
        tvPrice.setText(groupon.getPrice()+" сом");
        //Log.d("ooba2", "price "+groupon.getPrice());
        tvPriceTotal.setText(String.valueOf(groupon.getPriceTotal())+" сом");
        tvTitle.setText(groupon.getGoodsName());
        //tvDescription.setText(groupon.getHtml());
        Picasso.with(context).load(groupon.getPicUrl()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productIntent = new Intent(context, ProductActivity.class);

                productIntent.putExtra("product_url", groupon.getUrl());
                productIntent.putExtra("goods_id", groupon.getGoodsId());
                productIntent.putExtra("goods_pic_url", groupon.getPicUrl());
                productIntent.putExtra("goods_name", groupon.getGoodsName());
                productIntent.putExtra("goods_price", groupon.getPrice()+" сом");
                productIntent.putExtra("goods_quantity", String.valueOf(groupon.getCnt()));
                context.startActivity(productIntent);
            }
        });
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //if error cast container to view pager
        container.removeView((LinearLayout) object);
    }
}
