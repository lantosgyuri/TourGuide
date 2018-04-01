package com.example.lanto.tourguide.Outdoor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lanto.tourguide.R;

import java.util.ArrayList;


public class OutdoorFragment extends Fragment {

    private ArrayList<outdoorPojo> outDoorList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment_layout, container, false);

        ListView listView = rootView.findViewById(R.id.list_fragment_listView);

        //fill the Outdoor array list

        // i dont extract string resource hier becuse these are the names of the mountains
        outDoorList = new ArrayList<outdoorPojo>();
        outDoorList.add(new outdoorPojo("Kapf", "1160 m", R.drawable.kapf));
        outDoorList.add(new outdoorPojo("Guggersee", "1702 m", R.drawable.guggersee));
        outDoorList.add(new outdoorPojo("Breitenberg", "1884 m", R.drawable.breitenberg));
        outDoorList.add(new outdoorPojo("Alpspitz", "1450 m", R.drawable.alpspitz));
        outDoorList.add(new outdoorPojo("Aggenstein", "1890 m", R.drawable.aggenstein));
        outDoorList.add(new outdoorPojo("Falkenstein", "1091 m", R.drawable.falkenstein));
        outDoorList.add(new outdoorPojo("Sonnenkopf", "1712 m", R.drawable.sonnenkpof));

        outdoorAdapter adapter = new outdoorAdapter(getActivity(),outDoorList);

        listView.setAdapter(adapter);

        return rootView;
    }
}
