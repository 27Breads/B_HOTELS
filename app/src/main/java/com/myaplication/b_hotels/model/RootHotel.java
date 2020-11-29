package com.myaplication.b_hotels.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RootHotel {

    @SerializedName("hotel")
    private ArrayList<Hotel> hotel;

    public RootHotel(ArrayList<Hotel> hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(ArrayList<Hotel> hotel) {
        this.hotel = hotel;
    }
}