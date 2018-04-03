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
        outDoorList.add(new outdoorPojo(context.getString(R.string.kapf), context.getString(R.string.kapf_meter), R.drawable.kapf));
        outDoorList.add(new outdoorPojo(context.getString(R.string.guggersee), context.getString(R.string.giggersee_meter), R.drawable.guggersee));
        outDoorList.add(new outdoorPojo(context.getString(R.string.breitenberg), context.getString(R.string.breitenberg_meter), R.drawable.breitenberg));
        outDoorList.add(new outdoorPojo(context.getString(R.string.alpspitz), context.getString(R.string.alpspitz_meter), R.drawable.alpspitz));
        outDoorList.add(new outdoorPojo(context.getString(R.string.aggenstein), context.getString(R.string.aggenstein_meter), R.drawable.aggenstein));
        outDoorList.add(new outdoorPojo(context.getString(R.string.falkenstein), context.getString(R.string.falkenstein_meter), R.drawable.falkenstein));
        outDoorList.add(new outdoorPojo(context.getString(R.string.sonnenkopf), context.getString(R.string.sonnenkopf_meter), R.drawable.sonnenkpof));

        inDoorList = new ArrayList<IndoorPojo>();
        inDoorList.add(new IndoorPojo(context.getString(R.string.allgolino_wertach)));
        inDoorList.add(new IndoorPojo(context.getString(R.string.CamboMare)));
        inDoorList.add(new IndoorPojo(context.getString(R.string.Lina_laune)));
        inDoorList.add(new IndoorPojo(context.getString(R.string.golfarena)));
        inDoorList.add(new IndoorPojo(context.getString(R.string.Abc_nes)));
        inDoorList.add(new IndoorPojo(context.getString(R.string.schmetterling)));
        inDoorList.add(new IndoorPojo(context.getString(R.string.heimathaus)));
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