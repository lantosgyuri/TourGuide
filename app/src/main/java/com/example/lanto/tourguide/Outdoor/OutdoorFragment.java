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

        outDoorList = new ArrayList<outdoorPojo>();
        outDoorList.add(new outdoorPojo(getString(R.string.kapf), getString(R.string.kapf_meter), R.drawable.kapf));
        outDoorList.add(new outdoorPojo(getString(R.string.guggersee), getString(R.string.giggersee_meter), R.drawable.guggersee));
        outDoorList.add(new outdoorPojo(getString(R.string.breitenberg), getString(R.string.breitenberg_meter), R.drawable.breitenberg));
        outDoorList.add(new outdoorPojo(getString(R.string.alpspitz), getString(R.string.alpspitz_meter), R.drawable.alpspitz));
        outDoorList.add(new outdoorPojo(getString(R.string.aggenstein), getString(R.string.aggenstein_meter), R.drawable.aggenstein));
        outDoorList.add(new outdoorPojo(getString(R.string.falkenstein), getString(R.string.falkenstein_meter), R.drawable.falkenstein));
        outDoorList.add(new outdoorPojo(getString(R.string.sonnenkopf), getString(R.string.sonnenkopf_meter), R.drawable.sonnenkpof));

        outdoorAdapter adapter = new outdoorAdapter(getActivity(),outDoorList);

        listView.setAdapter(adapter);

        return rootView;
    }
}
