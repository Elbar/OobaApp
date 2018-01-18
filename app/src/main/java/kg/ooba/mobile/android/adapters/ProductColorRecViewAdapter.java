package kg.ooba.mobile.android.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import kg.ooba.mobile.android.R;

/**
 * Created by Begali on 9/9/2017.
 */

public class ProductColorRecViewAdapter extends RecyclerView.Adapter<ProductColorRecViewAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;

    public ProductColorRecViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView  = (ImageView) itemView.findViewById(R.id.product_color_image);
            progressBar = (ProgressBar) itemView.findViewById(R.id.product_color_progress_bar);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }
    }
}
