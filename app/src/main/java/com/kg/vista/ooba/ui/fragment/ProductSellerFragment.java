package com.kg.vista.ooba.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kg.vista.ooba.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSellerFragment extends Fragment {


    public ProductSellerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_seller, container, false);
    }

}
