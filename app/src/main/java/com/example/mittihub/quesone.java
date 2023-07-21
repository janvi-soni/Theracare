package com.example.mittihub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class quesone extends AppCompatActivity {
    TextView t;
    Slider s;
    Button btnext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quesone);
        t=findViewById(R.id.ttvv);
        s= findViewById(R.id.discreteSlider);
        s.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {

                t.setText(Float.toString(value));
                btnext=findViewById(R.id.btnext);
                btnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent one=new Intent(quesone.this,questwo.class);
                        one.putExtra( "sliderval",Float.toString(value).toString().trim());
                        startActivity(one);

                    }
                });

            }
        });


    }
}