package com.mpi.mpiseba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Service_10 extends AppCompatActivity {
    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    androidx.cardview.widget.CardView nonteacher1, nonteacher2, nonstu1, nonstu2, nonnotice, nonoffice1, nonoffice2, noninformation;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service10);


        back = findViewById(R.id.back3);
        nonteacher1 = findViewById(R.id.nonteacher1);
        nonteacher2 = findViewById(R.id.nonteacher2);
        nonstu1 = findViewById(R.id.nonstu1);
        nonstu2 = findViewById(R.id.nonstu2);
        nonnotice = findViewById(R.id.nonnotice);
        nonoffice1 = findViewById(R.id.nonoffice1);
        nonoffice2 = findViewById(R.id.nonoffice2);
        noninformation = findViewById(R.id.noninformation);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service_10.super.onBackPressed();
            }
        });

        nonteacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_10.this, Nonteacher1.class);
                startActivity(nextActivity);
            }
        });

        nonteacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_10.this, Nonteacher2.class);
                startActivity(nextActivity);
            }
        });

        nonoffice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_10.this, Nonoffice1.class);
                startActivity(nextActivity);
            }
        });

        nonoffice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_10.this, Nonoffice1.class);
                startActivity(nextActivity);
            }
        });

        nonstu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/";
                Web_browser.WEBSITE_TITLE="১ম সিফট খন্ড কালিন শিক্ষক";
                Intent myIntent=new Intent(Service_10.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        nonstu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/";
                Web_browser.WEBSITE_TITLE="১ম সিফট খন্ড কালিন শিক্ষক";
                Intent myIntent=new Intent(Service_10.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        nonnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(Service_10.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        noninformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_10.this, Infonon.class);
                startActivity(nextActivity);

            }
        });


    }

}

















