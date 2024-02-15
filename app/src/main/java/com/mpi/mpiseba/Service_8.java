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

public class Service_8 extends AppCompatActivity {
    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    androidx.cardview.widget.CardView Pwteacher1, Pwteacher2, pwstu1, pwstu2, pwnotice, pwoffice1, pwoffice2, pwinformation;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service8);


        back = findViewById(R.id.back3);
        Pwteacher1 = findViewById(R.id.teacherShift1);
        Pwteacher2 = findViewById(R.id.teacherShift2);
        pwstu1 = findViewById(R.id.pwstu1);
        pwstu2 = findViewById(R.id.pwstu2);
        pwnotice = findViewById(R.id.pwnotice);
        pwoffice1 = findViewById(R.id.pwoffice1);
        pwoffice2 = findViewById(R.id.pwoffice2);
        pwinformation = findViewById(R.id.pwinformation);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service_8.super.onBackPressed();
            }
        });



        Pwteacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_8.this,Pwteacher1.class);
                startActivity(nextActivity);
            }
        });

        Pwteacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_8.this,Pwteacher2.class);
                startActivity(nextActivity);
            }
        });

        pwoffice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_8.this,Pwoffice1.class);
                startActivity(nextActivity);
            }
        });

        pwoffice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_8.this,Pwoffice1.class);
                startActivity(nextActivity);
            }
        });

        pwstu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_8.this,Rutinpw.class);
                startActivity(nextActivity);

            }
        });

        pwstu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_8.this,pdfpwstu.class);
                startActivity(nextActivity);

            }
        });

        pwnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(Service_8.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        pwinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_8.this,Infopw.class);
                startActivity(nextActivity);

            }
        });

    }

}

















