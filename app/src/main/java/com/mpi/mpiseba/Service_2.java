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

public class Service_2 extends AppCompatActivity {
    AdView mAdView;
    InterstitialAd mInterstitialAd;


    public String num="";
     ImageView back2;
    LottieAnimationView Hospital1,Hospital2,Hospital3,Hospital4,Hospital5,Hospital6,Hospital7,Hospital8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service2);


        //Hospital1=findViewById(R.id.Hospital1);
        //Hospital2=findViewById(R.id.Hospital2);
        //Hospital3=findViewById(R.id.Hospital3);
        //Hospital4=findViewById(R.id.Hospital4);
        //Hospital5=findViewById(R.id.Hospital5);
        //Hospital6=findViewById(R.id.Hospital6);
        //Hospital7=findViewById(R.id.Hospital7);
        //Hospital8=findViewById(R.id.Hospital8);
        back2=findViewById(R.id.back2);

        mAdView=findViewById(R.id.adView);

        mAdView.setVisibility(View.GONE);


        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Service_2.super.onBackPressed();

            }
        });


    }
}