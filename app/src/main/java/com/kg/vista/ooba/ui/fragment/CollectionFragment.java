package com.kg.vista.ooba.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kg.vista.ooba.R;

import butterknife.ButterKnife;


public class CollectionFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.collection_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}