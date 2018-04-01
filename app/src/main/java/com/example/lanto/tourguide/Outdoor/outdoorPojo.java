package com.example.lanto.tourguide.Outdoor;

public class outdoorPojo {

    private String title;
    private String description;
    private int imageSrc;

    public outdoorPojo(String title, String description, int imageSrc) {
        this.title = title;
        this.description = description;
        this.imageSrc = imageSrc;
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

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }
}
