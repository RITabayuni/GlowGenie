package com.example.glowgenie.booking;

public class Doctor {
    private String name;
    private int imageResourceId;
    private String experience;
    private String specialization;
    private String clinic;
    private double rating;
    private int reviews;
    private String desc;
    private String workHour;

    public Doctor(String name, int imageResourceId, String experience, String specialization, String clinic, String desc, double rating, int reviews) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.experience = experience;
        this.specialization = specialization;
        this.clinic = clinic;
        this.desc = desc;
        this.rating = rating;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getExperience() {
        return experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getClinic() {
        return clinic;
    }

    public double getRating() {
        return rating;
    }

    public int getReviews() {
        return reviews;
    }

    public String getDesc() {
        return desc;
    }
}

