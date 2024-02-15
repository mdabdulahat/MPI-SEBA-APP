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
import android.widget.Toast;

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

public class Service_9 extends AppCompatActivity {
    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    androidx.cardview.widget.CardView Macteacher1, Macteacher2, etmstu1, etmstu2, etmnotice, etmoffice1, etmoffice2, etminformation;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service9);


        back = findViewById(R.id.back3);
        Macteacher1 = findViewById(R.id.teacherShift1);
        Macteacher2 = findViewById(R.id.teacherShift2);
        etmstu1 = findViewById(R.id.etmstu1);
        etmstu2 = findViewById(R.id.etmstu2);
        etmnotice = findViewById(R.id.etmnotice);
        etmoffice1 = findViewById(R.id.etmoffice1);
        etmoffice2 = findViewById(R.id.etmoffice2);
        etminformation = findViewById(R.id.etminformation);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service_9.super.onBackPressed();
            }
        });


        Macteacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_9.this,Macteacher1.class);
                startActivity(nextActivity);
            }
        });

        Macteacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_9.this,Macteacher2.class);
                startActivity(nextActivity);
            }
        });

        etmoffice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_9.this,ETMoffice1.class);
                startActivity(nextActivity);
            }
        });

        etmoffice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_9.this,ETMoffice1.class);
                startActivity(nextActivity);
            }
        });

        etmstu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Service_9.this,"দুঃখিত তথ্য এখনো পাওয়া যাইনি, খুব শিগ্রয় যুক্ত করা হবে", Toast.LENGTH_LONG).show();

            }
        });

        etmstu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_9.this,pdfetmstu.class);
                startActivity(nextActivity);

            }
        });

        etmnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(Service_9.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        etminformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_9.this,Infoetm.class);
                startActivity(nextActivity);

            }
        });



    }

}

















