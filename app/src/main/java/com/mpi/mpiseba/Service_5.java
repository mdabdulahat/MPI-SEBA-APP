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

public class Service_5 extends AppCompatActivity {
    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    androidx.cardview.widget.CardView Allnewscivil, Teachershift1, Teachershift2, etstu1, etstu2, etnotice, etoffice1, etoffice2, etinformation;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service5);


        back = findViewById(R.id.back3);
        Teachershift1  = findViewById(R.id.teacherShift1);
        Teachershift2 = findViewById(R.id.teacherShift2);
        etstu1 = findViewById(R.id.etstu1);
        etstu2 = findViewById(R.id.etstu2);
        etnotice = findViewById(R.id.etnotice);
        etoffice1 = findViewById(R.id.etoffice1);
        etoffice2 = findViewById(R.id.etoffice2);
        etinformation = findViewById(R.id.etinformation);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service_5.super.onBackPressed();
            }
        });



        Teachershift1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent nextActivity = new Intent(Service_5.this, ETteacher1.class);
               startActivity(nextActivity);
            }
        });


        Teachershift2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_5.this, ETteacher2.class);
                startActivity(nextActivity);
            }
        });

        etoffice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_5.this, EToffice1.class);
                startActivity(nextActivity);
            }
        });

        etoffice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_5.this, EToffice1.class);
                startActivity(nextActivity);
            }
        });

        etstu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_5.this, Rutinet.class);
                startActivity(nextActivity);

            }
        });

        etstu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_5.this, pdfetstu.class);
                startActivity(nextActivity);

            }
        });

        etnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(Service_5.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        etinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_5.this, Infoet.class);
                startActivity(nextActivity);

            }
        });


    }

}

















