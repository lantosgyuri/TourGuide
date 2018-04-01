package com.example.lanto.tourguide.Indoor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lanto.tourguide.MainActivity;
import com.example.lanto.tourguide.R;

import java.util.List;

public class indoorAdapter extends ArrayAdapter<IndoorPojo> {


    public indoorAdapter(@NonNull Context context, List<IndoorPojo> indoorPojos) {
        super(context, 0, indoorPojos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;

        if(convertView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.indoor_list_item, parent, false);

        }

        final IndoorPojo currentIndoor = getItem(position);

        TextView titleText = itemView.findViewById(R.id.list_item_fragment_title);
        TextView descText = itemView.findViewById(R.id.list_item_fragment_desc);

        titleText.setText(currentIndoor.getTitle());
        descText.setText(currentIndoor.getDescription());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.startBrowser(getContext(), currentIndoor.getUrl());

            }
        });

        return itemView;

    }
}
