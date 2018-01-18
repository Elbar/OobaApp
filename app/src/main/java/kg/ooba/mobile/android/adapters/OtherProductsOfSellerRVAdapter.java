package kg.ooba.mobile.android.adapters;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import kg.ooba.mobile.android.R;
import kg.ooba.mobile.android.model.Itemlist;
import kg.ooba.mobile.android.model.Shop;

/**
 * Created by Begali on 9/8/2017.
 */

public class OtherProductsOfSellerRVAdapter extends RecyclerView.Adapter<OtherProductsOfSellerRVAdapter.MyViewHolder> {


    Context context;
    List<Itemlist> itemlistList;
    LayoutInflater inflater;

    public OtherProductsOfSellerRVAdapter(Context context, List<Itemlist> itemlistList){
        this.context = context;
        this.itemlistList = itemlistList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public OtherProductsOfSellerRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.picture_item, parent, false);
        return new OtherProductsOfSellerRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OtherProductsOfSellerRVAdapter.MyViewHolder holder, int position) {

        Itemlist itemlist = itemlistList.get(position);

        Picasso.with(context).load(itemlist.getPicUrl()).into(holder.imageView, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError() {
                holder.progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemlistList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView  = (ImageView) itemView.findViewById(R.id.item_image);
            progressBar = (ProgressBar) itemView.findViewById(R.id.otherItemProgressBar);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }
    }
}