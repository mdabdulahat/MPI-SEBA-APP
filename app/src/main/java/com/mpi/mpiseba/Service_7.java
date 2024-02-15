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

public class Service_7 extends AppCompatActivity {

    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    androidx.cardview.widget.CardView Macteacher1, Macteacher2, macstu1, macstu2, macnotice, macoffice1, macoffice2, macinformation;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service7);


        back = findViewById(R.id.back3);
        Macteacher1 = findViewById(R.id.teacherShift1);
        Macteacher2 = findViewById(R.id.teacherShift2);
        macstu1 = findViewById(R.id.macstu1);
        macstu2 = findViewById(R.id.macstu2);
        macnotice = findViewById(R.id.macnotice);
        macoffice1 = findViewById(R.id.macoffice1);
        macoffice2 = findViewById(R.id.macoffice2);
        macinformation = findViewById(R.id.macinformation);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service_7.super.onBackPressed();
            }
        });


        Macteacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_7.this,Macteacher1.class);
                startActivity(nextActivity);
            }
        });

        Macteacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_7.this,Macteacher2.class);
                startActivity(nextActivity);
            }
        });

        macoffice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_7.this,Macoffice1.class);
                startActivity(nextActivity);
            }
        });

        macoffice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_7.this,Macoffice1.class);
                startActivity(nextActivity);
            }
        });

        macstu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_7.this,Rutinmac.class);
                startActivity(nextActivity);

            }
        });

        macstu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_7.this,pdfmacstu.class);
                startActivity(nextActivity);

            }
        });

        macnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(Service_7.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        macinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_7.this,Infomac.class);
                startActivity(nextActivity);

            }
        });


    }

}

















