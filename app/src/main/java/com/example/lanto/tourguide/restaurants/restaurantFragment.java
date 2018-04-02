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

    private static final String IlCastelloUrl = "http://www.ilcastello-nesselwang.com/";
    private static final String WildbachUrl = "http://www.wildbachalm.de/";
    private static final String KronenHutteUrl = "https://www.kronenhuette.de/";
    private static final String GasthofBarenUrl = "http://baeren-nesselwang.de/";
    private static final String LiftStubeUrl = "https://goo.gl/J4DpeK";
    private static final String GrillhouseUrl = "https://www.grillhouse-sonnenbichl.de/";
    private static final String KappelerUrl = "https://www.kappeleralp.de/";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment_layout, container, false);

        ListView listView = rootView.findViewById(R.id.list_fragment_listView);

        //fill the restaurant array list

        restaurantPojos = new ArrayList<restaurantPojo>();
        restaurantPojos.add(new restaurantPojo(getString(R.string.IlCastello), getString(R.string.pizzeria_restaurant), IlCastelloUrl, 5));
        restaurantPojos.add(new restaurantPojo(getString(R.string.Wildbach), getString(R.string.restaurant), WildbachUrl, 3));
        restaurantPojos.add(new restaurantPojo(getString(R.string.Kronenhutte), getString(R.string.berghutte), KronenHutteUrl, 4));
        restaurantPojos.add(new restaurantPojo(getString(R.string.GastHof_baren), getString(R.string.restaurant), GasthofBarenUrl, 3));
        restaurantPojos.add(new restaurantPojo(getString(R.string.Liftstube), getString((R.string.restaurant)), LiftStubeUrl, 2));
        restaurantPojos.add(new restaurantPojo(getString(R.string.Grillhouse), getString(R.string.grillhouse), GrillhouseUrl, 4));
        restaurantPojos.add(new restaurantPojo(getString(R.string.Kappeler_alp), getString(R.string.berghutte), KappelerUrl, 4));

        restaurantAdapter adapter = new restaurantAdapter(getContext(), restaurantPojos);

        listView.setAdapter(adapter);

        return rootView;
    }
}
