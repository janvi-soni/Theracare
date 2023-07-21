package com.example.mittihub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mood extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);
        c1=findViewById(R.id.mc1);
        c2=findViewById(R.id.mc2);
        c3=findViewById(R.id.mc3);
        c4=findViewById(R.id.mc4);
        c5=findViewById(R.id.mc5);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent k=new Intent(mood.this,happy.class);
                startActivity(k);

            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent k=new Intent(mood.this,happy.class);
                startActivity(k);

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent k=new Intent(mood.this,happy.class);
                startActivity(k);

            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent k=new Intent(mood.this,happy.class);
                startActivity(k);

            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent k=new Intent(mood.this,happy.class);
                startActivity(k);

            }
        });


    }
}