package com.kg.vista.ooba.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.kg.vista.ooba.R;
import com.kg.vista.ooba.model.Category;
import com.kg.vista.ooba.model.Child;
import com.kg.vista.ooba.ui.activity.ProductActivity;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.MyViewHolder> {

    public String TAG = "CategoryRVAdapter";
    Context context;
    private List<Category> categories;

    public CategoryRVAdapter(Context context, List<Category> categories) {

        this.categories = categories;
        this.context = context;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_category, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        final Category category = categories.get(position);


        holder.title.setText(category.getCatName());
        Picasso.with(context).load(R.drawable.noimage).into(holder.mCategoryIV);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cat = category.getChild();
                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(cat);
                    ArrayList<String> subcategories = new ArrayList<String>();
                    Child child = new Child();
                    for (int k = 0; k < jsonArray.length(); k++) {
                        JSONArray js = jsonArray.getJSONArray(k);
                        for (int j = 0; j < js.length(); j++) {

                            JSONObject jsob = js.getJSONObject(j);
                            String cat_name = jsob.getString("cat_name");
                            String  url = jsob.getString("url");
//                            child.setCatName(cat_name);
//                            child.setUrl(url);

                            subcategories.add(cat_name);


                        }
                    }


                    CharSequence[] cs = subcategories.toArray(new CharSequence[subcategories.size()]);

                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(holder.itemView.getContext());

                    dialogBuilder.setTitle("Подкатегории");

                    dialogBuilder.setItems(cs, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {


                            Intent intent = new Intent(context, ProductActivity.class);
                            intent.putExtra("url", "catalog/tmall/2");

                            context.startActivity(intent);
                        }
                    });
                    AlertDialog alertDialogObject = dialogBuilder.create();
                    alertDialogObject.show();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView mCategoryIV;
        CardView mCategoryCV;

        MyViewHolder(View view) {

            super(view);
            title = (TextView) view.findViewById(R.id.category_name);
            mCategoryIV = (ImageView) view.findViewById(R.id.category_iv);
            mCategoryCV = (CardView) view.findViewById(R.id.category_cv);
        }
    }
}