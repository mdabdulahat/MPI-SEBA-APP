package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class Service_3 extends AppCompatActivity {
    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    androidx.cardview.widget.CardView Teacher1, Teacher2, civilstudent, civilstudent2, civilnotice, Offices1, Offices2, civilinformation;

ImageView back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service3);


        back=findViewById(R.id.back3);
        Teacher1 = findViewById(R.id.teacherShift1);
        Teacher2 = findViewById(R.id.teacherShift2);
        civilstudent = findViewById(R.id.civilstudent);
        civilstudent2 = findViewById(R.id.civilstudent2);
        civilnotice = findViewById(R.id.civilnotice);
        Offices1 = findViewById(R.id.oficeohaok);
        Offices2 = findViewById(R.id.oficesohaok2);
        civilinformation = findViewById(R.id.civilinformation);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service_3.super.onBackPressed();
            }
        });

        Teacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(Service_3.this, Teachercivilsift1.class);
                startActivity(nextActivity);

            }
        });



        Teacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(Service_3.this, Teachers2.class);
                startActivity(nextActivity);

            }
        });



        civilstudent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_3.this, pdfcivistu.class);
                startActivity(nextActivity);
            }
        });

        civilstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_3.this, Rutincivil.class);
                startActivity(nextActivity);

            }
        });

        civilnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mpi.polytech.gov.bd/site/view/notices";
                Web_browser.WEBSITE_TITLE="সকল নোটিশ";
                Intent myIntent=new Intent(Service_3.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        civilinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextActivity = new Intent(Service_3.this, Infocivil.class);
                startActivity(nextActivity);

            }
        });

        Offices1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(Service_3.this, Civilofice1sift.class);
                startActivity(nextActivity);

            }
        });

        Offices2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Button 1
                Intent nextActivity = new Intent(Service_3.this, Civilofice1sift.class);
                startActivity(nextActivity);

            }
        });


    }

}

















