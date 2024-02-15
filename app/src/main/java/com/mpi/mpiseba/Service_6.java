package com.mpi.mpiseba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
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

public class Service_6 extends AppCompatActivity {
    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    androidx.cardview.widget.CardView Allnewscivil,  ETNteacher1, ETNteacher2, etnstu1, etnstu2, etnnotice, etnoffice1, etnoffice2, etninformation;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service6);


        back = findViewById(R.id.back3);
        ETNteacher1 = findViewById(R.id.etnTeacher1);
        ETNteacher2 = findViewById(R.id.etnTeacher2);
        etnstu1 = findViewById(R.id.etnstu1);
        etnstu2 = findViewById(R.id.etnstu2);
        etnnotice = findViewById(R.id.etnnotice);
        etnoffice1 = findViewById(R.id.etnoffice1);
        etnoffice2 = findViewById(R.id.etnoffice2);
        etninformation = findViewById(R.id.etninformation);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service_6.super.onBackPressed();
            }
        });

        ETNteacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_6.this, ETNteacher1.class);
                startActivity(nextActivity);
            }
        });

        ETNteacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_6.this, ETNteacher2.class);
                startActivity(nextActivity);
            }
        });

        etnoffice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_6.this, ETNoffice1.class);
                startActivity(nextActivity);
            }
        });

        etnoffice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Service_6.this, ETNoffice1.class);
                startActivity(nextActivity);
            }
        });

        etnstu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Service_6.this,"দুঃখিত তথ্য এখনো পাওয়া যাইনি, খুব শিগ্রয় যুক্ত করা হবে", Toast.LENGTH_LONG).show();

            }
        });

        etnstu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_6.this, pdfetnstu.class);
                startActivity(nextActivity);

            }
        });

        etnnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(Service_6.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        etninformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_6.this, Infoetn.class);
                startActivity(nextActivity);

            }
        });




    }

}

















