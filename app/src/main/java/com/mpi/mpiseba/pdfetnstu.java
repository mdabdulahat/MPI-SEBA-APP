package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

public class pdfetnstu extends AppCompatActivity {

    ImageView back;
    PDFView etstu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfetnstu);
        getWindow().setStatusBarColor(ContextCompat.getColor(pdfetnstu.this,R.color.app_themecolor));

        back=findViewById(R.id.back_about);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdfetnstu.super.onBackPressed();

            }
        });

        etstu = findViewById(R.id.etstupdf);
        etstu.fromAsset("alletnstudent.pdf").load();

    }
}