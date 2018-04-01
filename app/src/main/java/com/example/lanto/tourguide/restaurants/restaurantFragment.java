package com.example.lanto.tourguide.restaurants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lanto.tourguide.R;

import java.util.ArrayList;


public class restaurantFragment extends Fragment {

    private ArrayList<restaurantPojo> restaurantPojos;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment_layout, container, false);

        ListView listView = rootView.findViewById(R.id.list_fragment_listView);

        //fill the Indoor array list

        restaurantPojos = new ArrayList<restaurantPojo>();
        restaurantPojos.add(new restaurantPojo("Pizzeria Il Castello ", "Pizzeria, Restaurant",
                "http://www.ilcastello-nesselwang.com/", 5));
        restaurantPojos.add(new restaurantPojo("Wildbach-Alm", "Restaurant", "http://www.wildbachalm.de/", 3));
        restaurantPojos.add(new restaurantPojo("Kronenhütte", "Berghütte", "https://www.kronenhuette.de/", 4));
        restaurantPojos.add(new restaurantPojo("Gasthof Bären", "Brauerei", "http://baeren-nesselwang.de/", 3));
        restaurantPojos.add(new restaurantPojo("LiftStüble", "Restaurant", "https://goo.gl/J4DpeK", 2));
        restaurantPojos.add(new restaurantPojo("Grillhouse Sonnenbichl", "Grillhouse", "https://www.grillhouse-sonnenbichl.de/", 4));
        restaurantPojos.add(new restaurantPojo("Kappeler Alp", "Berghütte", "https://www.kappeleralp.de/", 4));

        restaurantAdapter adapter = new restaurantAdapter(getContext(), restaurantPojos);

        listView.setAdapter(adapter);

        return rootView;
    }
}
