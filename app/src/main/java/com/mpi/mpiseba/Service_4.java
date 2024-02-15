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

public class Service_4 extends AppCompatActivity {
    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    androidx.cardview.widget.CardView Comteacher1, Comteacher2, Comstu1, comstu2, comnotice, comoffice1, comoffice2, cominformation;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service4);


        back = findViewById(R.id.back3);
        Comteacher1 = findViewById(R.id.comTeacher1);
        Comteacher2 = findViewById(R.id.comTeacher2);
        Comstu1 = findViewById(R.id.comstu1);
        comstu2 = findViewById(R.id.comstu2);
        comnotice = findViewById(R.id.comnotice);
        comoffice1 = findViewById(R.id.comOffice1);
        comoffice2 = findViewById(R.id.comOffice2);
        cominformation = findViewById(R.id.cominformation);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service_4.super.onBackPressed();
            }
        });


        Comteacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(Service_4.this, Comteacher1.class);
                startActivity(nextActivity);

            }
        });

        Comteacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(Service_4.this, Comteacher2.class);
                startActivity(nextActivity);

            }
        });

        comoffice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(Service_4.this, Comoffice1.class);
                startActivity(nextActivity);

            }
        });

        comoffice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(Service_4.this, Comoffice1.class);
                startActivity(nextActivity);

            }
        });

        Comstu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_4.this, Rutincom.class);
                startActivity(nextActivity);

            }
        });

        comstu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_4.this, pdfcomstu.class);
                startActivity(nextActivity);

            }
        });

        comnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(Service_4.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        cominformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_4.this, Infocom.class);
                startActivity(nextActivity);

            }
        });


    }

}

















