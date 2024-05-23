package com.example.glowgenie.appointment;

import java.time.LocalDate;

public class AppointmentHistoryModel {
    private String doctorName, diagnosis, complaint, drugTherapy;
    private LocalDate date;
    private int doctorImage;
    private int ratingImage;

    // Constructor, getters and setters
    public AppointmentHistoryModel(String doctorName, LocalDate date, String diagnosis, String complaint, String drugTherapy, int doctorImage, int ratingImage) {
        this.doctorName = doctorName;
        this.date = date;
        this.diagnosis = diagnosis;
        this.complaint = complaint;
        this.drugTherapy = drugTherapy;
        this.doctorImage = doctorImage;
        this.ratingImage = ratingImage;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getComplaint() {
        return complaint;
    }
    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
    public String getDrugTherapy() {
        return drugTherapy;
    }
    public void setDrugTherapy(String drugTherapy) {
        this.drugTherapy = drugTherapy;
    }
    public int getDoctorImage() {
        return doctorImage;
    }
    public void setDoctorImage(int doctorImage) {
        this.doctorImage = doctorImage;
    }
    public int getRatingImage() {
        return ratingImage;
    }
    public void setRatingImage(int ratingImage) {
        this.ratingImage = ratingImage;
    }
}
