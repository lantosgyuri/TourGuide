package com.example.lanto.tourguide.restaurants;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lanto.tourguide.MainActivity;
import com.example.lanto.tourguide.R;

import java.util.ArrayList;

public class restaurantAdapter extends ArrayAdapter<restaurantPojo> {


    public restaurantAdapter(@NonNull Context context, ArrayList<restaurantPojo> restaurantPojos) {
        super(context, 0, restaurantPojos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;

        if(convertView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.restaurant_list_item, parent, false);

        }

        final restaurantPojo currentRestaurant= getItem(position);

        TextView titleText = itemView.findViewById(R.id.list_item_fragment_title);
        TextView descText = itemView.findViewById(R.id.list_item_fragment_desc);
        RatingBar ratingBar = itemView.findViewById(R.id.rating_bar);


        titleText.setText(currentRestaurant.getName());
        descText.setText(currentRestaurant.getAdress());
        ratingBar.setRating(currentRestaurant.getRating());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.startBrowser(getContext(), currentRestaurant.getUrl());
            }
        });

        return itemView;

    }
}
