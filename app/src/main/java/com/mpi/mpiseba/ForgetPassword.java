package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;

import java.net.URISyntaxException;

public class ForgetPassword extends AppCompatActivity {
    public String num="";


    ImageView back;
    Button massage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);


        back=findViewById(R.id.back3);
        massage = findViewById(R.id.massage);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForgetPassword.super.onBackPressed();
            }
        });


        massage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri;
                uri = Uri.parse("https://wa.me/+8801948426782");
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browserIntent);

            }
        });

    }

}



