package com.example.lanto.tourguide.Reccomended;

import java.util.ArrayList;

public class Contract {

    interface show {
        void show(String weatherType, ArrayList<RecommendedPojo> recommendList);
    }

    interface getRecommendedList{
        void isRaining(String weatherCondition);
    }

}
