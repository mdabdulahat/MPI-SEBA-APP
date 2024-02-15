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

public class Service_11 extends AppCompatActivity {


    AdView mAdView;
    InterstitialAd mInterstitialAd;
    LottieAnimationView hotel1,hotel2,hotel3,hotel4,hotel5;
    ImageView back;
    public String num="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service11);


        hotel1=findViewById(R.id.hotel1);
        hotel2=findViewById(R.id.hotel2);
        hotel3=findViewById(R.id.hotel3);
        hotel4=findViewById(R.id.hotel4);
        hotel5=findViewById(R.id.hotel5);


        back=findViewById(R.id.back11);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Service_11.super.onBackPressed();

            }
        });




        //======================================Hotel==================================================//

        hotel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01789-031073";
                callPhoneNumber();
            }
        });
        hotel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01979-966218";
                callPhoneNumber();
            }
        });
        hotel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01826-635200";
                callPhoneNumber();
            }
        });
        hotel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01705-301720";
                callPhoneNumber();
            }
        });
        hotel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="01718-087171";
                callPhoneNumber();
            }
        });
    }


    //......................call method.....................//

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if(requestCode == 101)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callPhoneNumber();
            }
        }
    }

    public void callPhoneNumber()
    {
        try
        {
            if(Build.VERSION.SDK_INT > 22)
            {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Service_11.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);

            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                startActivity(callIntent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //==================================================================================//

    //==============================================Banner ad start=============================//

}