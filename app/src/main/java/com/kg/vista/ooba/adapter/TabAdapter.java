package com.kg.vista.ooba.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kg.vista.ooba.ui.fragment.ProductInfoFragment;
import com.kg.vista.ooba.ui.fragment.ProductReviewsFragment;
import com.kg.vista.ooba.ui.fragment.ProductSellerFragment;



public class TabAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;
    private ProductInfoFragment productInfoFragment;
    private ProductReviewsFragment productReviewsFragment;
    private ProductSellerFragment productSellerFragment;
    public TabAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        productInfoFragment = new ProductInfoFragment();
        productReviewsFragment = new ProductReviewsFragment();
        productSellerFragment = new ProductSellerFragment();
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return productInfoFragment;
            case 1:
                return productSellerFragment;
            case 2:
                return productReviewsFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}

