package com.myaplication.b_hotels.rest;

import com.myaplication.b_hotels.model.RootHotel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("purwakarta/hotel")  //end point
    Call<RootHotel> getData();
}
