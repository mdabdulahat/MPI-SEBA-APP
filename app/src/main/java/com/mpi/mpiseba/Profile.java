package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class Profile extends AppCompatActivity {


    AdView mAdView;
    InterstitialAd mInterstitialAd;
    CardView Eseba1,Eseba2,Eseba3,Eseba4,Eseba5,Eseba6,Eseba7;
    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile3);

       back=findViewById(R.id.back12);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Profile.super.onBackPressed();

           }
       });

        //========================================end=====================================//


    }










}