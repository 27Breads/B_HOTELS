package com.myaplication.b_hotels;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myaplication.b_hotels.model.Hotel;
import com.myaplication.b_hotels.model.RootHotel;
import com.myaplication.b_hotels.rest.ApiConfig;
import com.myaplication.b_hotels.rest.ApiService;
import com.myaplication.b_hotels.model.Hotel;
import com.myaplication.b_hotels.rest.ApiConfig;
import com.myaplication.b_hotels.rest.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListHotelActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Hotel> hotels;
    private HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hotel);

        initView();
        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData()
                .enqueue(new Callback<RootHotel>() {
                    @Override
                    public void onResponse(Call<RootHotel> call, Response<RootHotel> response) {
                        if(response.isSuccessful()){
                            hotels = (ArrayList<Hotel>) response.body().getHotel();
                            hotelAdapter = new HotelAdapter(hotels, getApplicationContext());
                            hotelAdapter.notifyDataSetChanged();
                            rv.setAdapter(hotelAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        }
                    }

                    @Override
                    public void onFailure(Call<RootHotel> call, Throwable t) {
                        Toast.makeText(ListHotelActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }
}
