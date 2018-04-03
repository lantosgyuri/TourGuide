package com.example.lanto.tourguide.Indoor;

public class IndoorPojo {

    private String title;
    private String description;
    private String url;

    public IndoorPojo(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public IndoorPojo(String title){
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
