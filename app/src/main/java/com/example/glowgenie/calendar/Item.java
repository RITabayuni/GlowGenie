package com.example.glowgenie.calendar;

import android.widget.ListView;

public class Item {

    String Schedule, DaySkincare, Morning, Night;

    public Item(String schedule, String dayskincare, String morning, String night) {
        Schedule = schedule;
        DaySkincare = dayskincare;
        Morning = morning;
        Night = night;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public String getDaySkincare() {
        return DaySkincare;
    }

    public void setDaySkincare(String daySkincare) {
        DaySkincare = daySkincare;
    }

    public String getMorning() {
        return Morning;
    }

    public void setMorning(String morning) {
        Morning = morning;
    }

    public String getNight() {
        return Night;
    }

    public void setNight(String night) {
        Night = night;
    }


}
