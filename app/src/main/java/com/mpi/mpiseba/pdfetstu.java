package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

public class pdfetstu extends AppCompatActivity {

    ImageView back;
    PDFView etstu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfetstu);
        getWindow().setStatusBarColor(ContextCompat.getColor(pdfetstu.this,R.color.app_themecolor));

        back=findViewById(R.id.back_about);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdfetstu.super.onBackPressed();

            }
        });

        etstu = findViewById(R.id.etstupdf);
        etstu.fromAsset("alletstudent.pdf").load();

    }
}