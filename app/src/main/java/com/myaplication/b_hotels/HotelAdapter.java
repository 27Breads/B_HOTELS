package com.myaplication.b_hotels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myaplication.b_hotels.model.Hotel;.model.Hotel;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private ArrayList<Hotel> hotels;
    private Context context;



    public HotelAdapter(ArrayList<Hotel> hotels, Context context){
        this.hotels = hotels;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder holder, final int position) {
        holder.tvTitle.setText(hotels.get(position).getNama());
        Glide.with(context).load(hotels.get(position).getGambar_url()).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(holder.iv);

        holder.cvKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("nama", hotels.get(position).getNama());
                intent.putExtra("alamat", hotels.get(position).getAlamat());
                intent.putExtra("nomor_telp", hotels.get(position).getNomor_telp());
                intent.putExtra("kordinat", hotels.get(position).getKordinat());
                intent.putExtra("gambar_url", hotels.get(position).getGambar_url());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tvTitle;
        private CardView cvKlik;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tvTitle = itemView.findViewById(R.id.tv_nama);
            cvKlik = itemView.findViewById(R.id.cv_klik);
        }

    }
}