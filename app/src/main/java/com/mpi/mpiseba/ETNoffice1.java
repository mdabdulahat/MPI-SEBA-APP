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

public class ETNoffice1 extends AppCompatActivity {
    public String num="";

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    ImageView back;
    LottieAnimationView doner1,doner2,doner3,doner4,doner5,doner6,doner7,doner8, doner9, doner10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etnoffice1);


        doner1=findViewById(R.id.Doner1);
        doner2=findViewById(R.id.Doner2);
        doner3=findViewById(R.id.Doner3);
        doner4=findViewById(R.id.Doner4);
        doner5=findViewById(R.id.Doner5);
        doner6=findViewById(R.id.Doner6);
        doner7=findViewById(R.id.Doner7);
        doner8=findViewById(R.id.Doner8);
        doner9=findViewById(R.id.Doner9);
        doner10=findViewById(R.id.Doner10);
        back=findViewById(R.id.back3);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ETNoffice1.super.onBackPressed();
            }
        });





        //===============================Doner===================================================//
        doner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৭২৫৫৪৬৪৫০";
                callPhoneNumber();
            }
        });
        doner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৫১৮৩৭৬৮৩১";
                callPhoneNumber();
            }
        });
        doner3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৯২৬৩৮১১৪১";
                callPhoneNumber();
            }
        });
        doner4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৭৯৪৬৪৭০৬৯";
                callPhoneNumber();
            }
        });
        doner5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৮৫৫৯৮৩৮১৯";
                callPhoneNumber();
            }
        });
        doner6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৮৭৭৯০৪৪৮৪";
                callPhoneNumber();
            }
        });

        doner7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৭৪৩০৭২৯৯৯";
                callPhoneNumber();
            }
        });

        doner8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৭৮৪৪৩৪৮০০";
                callPhoneNumber();
            }
        });

        doner9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৭২৬১৯৯৯১৩";
                callPhoneNumber();
            }
        });

        doner10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="০১৭১১৯৮৫৬৯০";
                callPhoneNumber();
            }
        });


        //===============================end======================================================//


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
                    ActivityCompat.requestPermissions(ETNoffice1.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
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
















    //=======================onBAckpressed ads show End=======================================//
}