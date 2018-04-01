package com.example.lanto.tourguide.Reccomended;

import android.content.Context;

import com.example.lanto.tourguide.Indoor.IndoorPojo;
import com.example.lanto.tourguide.Outdoor.outdoorPojo;
import com.example.lanto.tourguide.R;

import java.util.ArrayList;

public class Presenter implements Contract.getRecommendedList {

    private Contract.show mShowInterface;
    private ArrayList<IndoorPojo> inDoorList;
    private ArrayList<outdoorPojo> outDoorList;
    private Context context;

    public Presenter(Contract.show showInterface, Context context) {

        mShowInterface = showInterface;
        this.context = context;

        /**
         fill the outdoor and indoor objects to able to recommend. The same as in the fragments
         real life case i would use a cursor loader.
         */

        outDoorList = new ArrayList<outdoorPojo>();
        outDoorList.add(new outdoorPojo("Kapf", "1160 m", R.drawable.kapf));
        outDoorList.add(new outdoorPojo("Guggersee", "1702 m", R.drawable.guggersee));
        outDoorList.add(new outdoorPojo("Breitenberg", "1884 m", R.drawable.breitenberg));
        outDoorList.add(new outdoorPojo("Alpspitz", "1450 m", R.drawable.alpspitz));
        outDoorList.add(new outdoorPojo("Aggenstein", "1890 m", R.drawable.aggenstein));
        outDoorList.add(new outdoorPojo("Falkenstein", "1091 m", R.drawable.falkenstein));
        outDoorList.add(new outdoorPojo("Sonnenkopf", "1712 m", R.drawable.sonnenkpof));

        inDoorList = new ArrayList<IndoorPojo>();
        inDoorList.add(new IndoorPojo(context.getString(R.string.allgolino_wertach), context.getString(R.string.indoorspielplatz), "http://www.allgaeulino.de/"));
        inDoorList.add(new IndoorPojo(context.getString(R.string.CamboMare), context.getString(R.string.hallenbad_sauna), "https://www.cambomare.de/"));
        inDoorList.add(new IndoorPojo(context.getString(R.string.Lina_laune), context.getString(R.string.hallengolfplatz), "http://www.golfarena-allgaeu.de/"));
        inDoorList.add(new IndoorPojo(context.getString(R.string.Abc_nes), context.getString(R.string.erlebnisbad), "http://www.abc-nesselwang.de/"));
        inDoorList.add(new IndoorPojo(context.getString(R.string.schmetterling), context.getString(R.string.zoo_pfronten), "https://www.schmetterling-erlebniswelt.de/"));
        inDoorList.add(new IndoorPojo(context.getString(R.string.heimathaus), context.getString(R.string.museum_nes), "http://www.nesselwang-buergerservice.de/heimathaus.0.html"));
    }


    @Override
    public void isRaining(String weatherCondition) {
        ArrayList<RecommendedPojo> recommendedList = new ArrayList<>();
        String suggestedText = "";

        //make the recommended List
        if (weatherCondition.equals("Rain")) {
            for (int i = 0; i < inDoorList.size(); i++) {
                RecommendedPojo currentRecommendPojo = new RecommendedPojo(inDoorList.get(i).getTitle());
                recommendedList.add(currentRecommendPojo);
                suggestedText = context.getString(R.string.wetter_not_nice);
            }


        } else {
            for (int i = 0; i < outDoorList.size(); i++) {
                RecommendedPojo currentRecommendPojo = new RecommendedPojo(outDoorList.get(i).getTitle());
               recommendedList.add(currentRecommendPojo);
                suggestedText = context.getString(R.string.weather_nice);
            }
       }

        mShowInterface.show(suggestedText, recommendedList);
    }

}