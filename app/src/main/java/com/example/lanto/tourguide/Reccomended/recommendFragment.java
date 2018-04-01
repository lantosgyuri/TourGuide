package com.example.lanto.tourguide.Reccomended;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lanto.tourguide.R;

import java.util.ArrayList;


public class recommendFragment extends Fragment implements com.example.lanto.tourguide.Reccomended.Contract.show {

    TextView weatherText;
    ListView listView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recommended_layout, container, false);

        //bind the views
        weatherText = rootView.findViewById(R.id.recommend_weather_text);
        listView = rootView.findViewById(R.id.recommend_listView);

        //make the presenter
        Presenter presenter = new Presenter(this, getActivity());

        //bind the getData object with the presenter
        getWeatherData getData = new getWeatherData(presenter, getActivity());

        //kick off the loader
        getData.execute();

        return rootView;
    }

    @Override
    public void show(String weatherType, ArrayList<RecommendedPojo> recommendedList) {
        weatherText.setText(weatherType);
        ViewAdapter adapter = new ViewAdapter(getActivity(), recommendedList);
        listView.setAdapter(adapter);
    }

}
