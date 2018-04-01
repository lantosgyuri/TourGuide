package com.example.lanto.tourguide.Reccomended;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lanto.tourguide.R;

import java.util.List;

public class ViewAdapter extends ArrayAdapter<RecommendedPojo> {

    public ViewAdapter(@NonNull Context context, @NonNull List<RecommendedPojo> recommendPojo) {
        super(context, 0, recommendPojo);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (convertView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.recommended_list_item, parent, false);
        }

        RecommendedPojo currentItem = getItem(position);

        TextView titleText = listItemView.findViewById(R.id.recommend_list_item);
        titleText.setText(currentItem.getnTitle());

        return listItemView;
    }
}
