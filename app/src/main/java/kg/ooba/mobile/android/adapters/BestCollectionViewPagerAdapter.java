package kg.ooba.mobile.android.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.model.Collection;
import kg.ooba.mobile.android.model.Groupon;

/**
 * Created by Begali on 9/4/2017.
 */

public class BestCollectionViewPagerAdapter extends PagerAdapter {

    Context context;
    List<Collection> collectionsList;
    LayoutInflater inflater;

    public BestCollectionViewPagerAdapter(Context context, List<Collection> collectionsList){
        this.context = context;
        this.collectionsList = collectionsList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = inflater.inflate(R.layout.best_collection_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.best_collections_image);
        TextView tvTitle = (TextView) itemView.findViewById(R.id.best_collections_title);
        //TextView tvDescription = itemView.findViewById(R.id.best_collections_description);
        final ProgressBar progressBar = (ProgressBar) itemView.findViewById(R.id.bestCollectionProgressBar);

        Collection collection = collectionsList.get(position);
        //Log.d("ooba2", "price "+groupon.getPrice());
        tvTitle.setText(collection.getTitle());
        //tvDescription.setText(collection.getInfo());
        Picasso.with(context).load("http://ooba.kg/"+collection.getPicUrl()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        container.addView(itemView);

        return itemView;
    }

    @Override
    public int getCount() {
        return collectionsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //if error cast container to view pager
        container.removeView((LinearLayout) object);
    }
}
