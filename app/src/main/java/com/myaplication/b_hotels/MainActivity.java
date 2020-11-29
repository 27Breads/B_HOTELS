package com.myaplication.b_hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private MaterialCardView mPengetahuan;
    private MaterialCardView mProfil;
    private MaterialCardView mAlarm;
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.myaplication.b_hotels";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

    }

    private void initView() {
        mPengetahuan = (MaterialCardView) findViewById(R.id.cv_pengetahuan);
        mProfil = (MaterialCardView) findViewById(R.id.cv_profil);
        mAlarm= (MaterialCardView) findViewById(R.id.cv_alarm);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.apply();
    }
}