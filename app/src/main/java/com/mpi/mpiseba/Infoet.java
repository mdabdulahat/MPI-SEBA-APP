package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

public class Infoet extends AppCompatActivity {

    ImageView back;
    PDFView civilstu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoet);
        getWindow().setStatusBarColor(ContextCompat.getColor(Infoet.this,R.color.app_themecolor));

        back=findViewById(R.id.back_about);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Infoet.super.onBackPressed();

            }
        });

        civilstu = findViewById(R.id.civilstupdf);
        civilstu.fromAsset("informationet.pdf").load();

    }
}