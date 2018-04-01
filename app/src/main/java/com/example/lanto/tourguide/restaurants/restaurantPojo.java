package com.example.lanto.tourguide.restaurants;

public class restaurantPojo {

    private String name;
    private String adress;
    private float rating;
    private String url;

    public restaurantPojo(String name, String adress, String url, int rating) {
        this.name = name;
        this.adress = adress;
        this.rating = rating;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
