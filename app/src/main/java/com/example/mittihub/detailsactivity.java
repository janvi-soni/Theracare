package com.example.mittihub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detailsactivity extends AppCompatActivity {
    TextView t01,t02,t03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);
        String Group=getIntent().getStringExtra("Group");
        String Description=getIntent().getStringExtra("Description");
        String Members=getIntent().getStringExtra("Members");
        t01=findViewById(R.id.ij1);
        t02=findViewById(R.id.ij2);
        t03=findViewById(R.id.ij3);
        t01.setText(Group);
        t02.setText(Description);
//        t03.setText(Members);
    }
}