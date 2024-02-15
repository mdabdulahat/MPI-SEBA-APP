package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Developer extends AppCompatActivity {


    LinearLayout Facebook, YouTube, Instagram, Website;
    ImageView back;
    CardView Call_me;
    public String num="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        Call_me=findViewById(R.id.mycall);
        Facebook=findViewById(R.id.facebook);
        YouTube=findViewById(R.id.youtube);
        Instagram=findViewById(R.id.instagram);
        Website=findViewById(R.id.website);

        TextView tv = (TextView) this.findViewById(R.id.mywidget);
        tv.setSelected(true);  // Set focus to the textview

        back=findViewById(R.id.back_developer);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Developer.super.onBackPressed();

            }
        });

        Call_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num="+8801948426782";
                callPhoneNumber();
            }
        });

        Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://www.facebook.com/ahad8952";
                Web_browser.WEBSITE_TITLE="My facebook Account";
                Intent myIntent=new Intent(Developer.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        YouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://www.youtube.com/@vlogerahad";
                Web_browser.WEBSITE_TITLE="My YouTube Chanal";
                Intent myIntent=new Intent(Developer.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        Instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://www.instagram.com/ahatmdabdul?igsh=MWxocG92MGVleW42cA==";
                Web_browser.WEBSITE_TITLE="My Instagram Account";
                Intent myIntent=new Intent(Developer.this,Web_browser.class);
                startActivity(myIntent);

            }
        });

        Website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Web_browser.WEBSITE_LINK="https://mdabdulahad.netlify.app/";
                Web_browser.WEBSITE_TITLE="My Portfolio Site";
                Intent myIntent=new Intent(Developer.this,Web_browser.class);
                startActivity(myIntent);

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
                    ActivityCompat.requestPermissions(Developer.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
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
}