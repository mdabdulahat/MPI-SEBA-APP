package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class allCaptain extends AppCompatActivity {
    public String num="";


    ImageView back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_captain);


        back=findViewById(R.id.back3);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCaptain.super.onBackPressed();
            }
        });


    }

}

















