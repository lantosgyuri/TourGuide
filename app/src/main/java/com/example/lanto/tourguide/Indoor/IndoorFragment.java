package com.example.lanto.tourguide.Indoor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lanto.tourguide.R;

import java.util.ArrayList;


public class IndoorFragment extends Fragment {

    private ArrayList<IndoorPojo> inDoorList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment_layout, container, false);

        ListView listView = rootView.findViewById(R.id.list_fragment_listView);

        //fill the Indoor array list

        inDoorList = new ArrayList<IndoorPojo>();
        inDoorList.add(new IndoorPojo(getString(R.string.allgolino_wertach), getString(R.string.indoorspielplatz), "http://www.allgaeulino.de/"));
        inDoorList.add(new IndoorPojo(getString(R.string.CamboMare), getString(R.string.hallenbad_sauna), "https://www.cambomare.de/"));
        inDoorList.add(new IndoorPojo(getString(R.string.Lina_laune), getString(R.string.indoorspielplatz), "https://linalauneland.de/"));
        inDoorList.add(new IndoorPojo(getString(R.string.golfarena), getString(R.string.hallengolfplatz), "http://www.golfarena-allgaeu.de/"));
        inDoorList.add(new IndoorPojo(getString(R.string.Abc_nes), getString(R.string.erlebnisbad), "http://www.abc-nesselwang.de/"));
        inDoorList.add(new IndoorPojo(getString(R.string.schmetterling), getString(R.string.zoo_pfronten), "https://www.schmetterling-erlebniswelt.de/"));
        inDoorList.add(new IndoorPojo(getString(R.string.heimathaus), getString(R.string.museum_nes), "http://www.nesselwang-buergerservice.de/heimathaus.0.html"));

        indoorAdapter adapter = new indoorAdapter(getActivity(),inDoorList);

        listView.setAdapter(adapter);

        return rootView;
    }
}
