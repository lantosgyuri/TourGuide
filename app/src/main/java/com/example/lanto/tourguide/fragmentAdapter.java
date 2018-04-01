package com.example.lanto.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lanto.tourguide.Indoor.IndoorFragment;
import com.example.lanto.tourguide.Outdoor.OutdoorFragment;
import com.example.lanto.tourguide.Reccomended.recommendFragment;
import com.example.lanto.tourguide.restaurants.restaurantFragment;

public class fragmentAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public fragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new recommendFragment();
        } else if (position == 1) {
            return new IndoorFragment();
        } else if (position == 2){
            return new OutdoorFragment();
        } else return new restaurantFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.recommend_category);
        } else if (position == 1) {
            return mContext.getString(R.string.indoor_category);
        } else if (position == 2){
            return mContext.getString(R.string.outdoor_category);

        } else return mContext.getString(R.string.restaurant_category);
    }
}