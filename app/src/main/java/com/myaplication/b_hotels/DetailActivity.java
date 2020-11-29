package com.myaplication.b_hotels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivDetail;
    private TextView tvNama;
    private TextView tvAlamat;
    private TextView tvNomortelp;
    private TextView tvKordinat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle(getIntent().getStringExtra("nama"));
        tvAlamat.setText("Alamat Hotel :  " + getIntent().getStringExtra( "alamat"));
        tvNomortelp.setText("Nomor Telepon Hotel : " + getIntent().getStringExtra("nomor_telp"));
        tvKordinat.setText("Kordinat Hotel :  " + getIntent().getStringExtra("kordinat"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("gambar_url")).error(R.drawable.ic_launcher_background)
                .override(512, 512)
                .into(ivDetail);

        // Share Info
        FloatingActionButton fab = findViewById(R.id.share);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gambar_url = "Link Gambar Hotel : " + getIntent().getStringExtra("gambar_url");
                String nama = "Nama Hotel : " + getIntent().getStringExtra("nama");
                String alamat = "Alamat Hotel : " + getIntent().getStringExtra("alamat");
                String nomor_telp = "Nomor Telepon Hotel : " + getIntent().getStringExtra("nomor_telp");
                String kordinat = "Kordinat Hotel :  " + getIntent().getStringExtra("kordinat");

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, nama + "\n\n" + alamat + "\n\n" + nomor_telp +
                        "\n\n" +kordinat + "\n\n" + gambar_url);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, "Bagikan ke :");
                startActivity(shareIntent);
            }
        });
    }

    private void initView() {
        ivDetail = findViewById(R.id.iv_detail);
        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvNomortelp = findViewById(R.id.tv_nomortelp);
        tvKordinat = findViewById(R.id.tv_kordinat);
    }
}