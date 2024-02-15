package com.mpi.mpiseba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

public class pdfcivistu extends AppCompatActivity {

    ImageView back;
    PDFView civilstu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfcivilstu);
        getWindow().setStatusBarColor(ContextCompat.getColor(pdfcivistu.this,R.color.app_themecolor));

        back=findViewById(R.id.back_about);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdfcivistu.super.onBackPressed();

            }
        });

        civilstu = findViewById(R.id.civilstupdf);
        civilstu.fromAsset("allcivilstudent.pdf").load();

    }
}