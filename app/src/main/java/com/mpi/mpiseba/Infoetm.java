package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

public class Infoetm extends AppCompatActivity {

    ImageView back;
    PDFView civilstu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoetm);
        getWindow().setStatusBarColor(ContextCompat.getColor(Infoetm.this,R.color.app_themecolor));

        back=findViewById(R.id.back_about);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Infoetm.super.onBackPressed();

            }
        });

        civilstu = findViewById(R.id.civilstupdf);
        civilstu.fromAsset("informationetm.pdf").load();

    }
}