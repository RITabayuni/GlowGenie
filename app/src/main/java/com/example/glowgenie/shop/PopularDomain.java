package com.example.glowgenie.shop;

public class PopularDomain {
    private String title;
    private String location;
    private int price;
    private int imgresource;

    public PopularDomain(String title, String location, int price, int imgresource) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.imgresource = imgresource;
    }

    public int getImgresource() {
        return imgresource;
    }

    public void setImgresource(int imgresource) {
        this.imgresource = imgresource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
