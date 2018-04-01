package com.example.lanto.tourguide.Outdoor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lanto.tourguide.R;

import java.util.List;

public class outdoorAdapter extends ArrayAdapter<outdoorPojo> {


    public outdoorAdapter(@NonNull Context context, List<outdoorPojo> outdoorPojos) {
        super(context, 0, outdoorPojos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;

        if(convertView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.outdoor_list_item, parent, false);

        }

        outdoorPojo currentOutdoor = getItem(position);

        TextView titleText = itemView.findViewById(R.id.list_item_fragment_title);
        TextView descText = itemView.findViewById(R.id.list_item_fragment_desc);
        ImageView imageView = itemView.findViewById(R.id.outdoor_imageview);


        titleText.setText(currentOutdoor.getTitle());
        descText.setText(currentOutdoor.getDescription());
        imageView.setImageResource(currentOutdoor.getImageSrc());

        return itemView;

    }
}
