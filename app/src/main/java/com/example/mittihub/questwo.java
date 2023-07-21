package com.example.mittihub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class questwo extends AppCompatActivity {
    Button b;
    TextView t1,t2,t3,t4,t5,t6;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questwo);

        b=findViewById(R.id.b);
        t1=findViewById(R.id.tj1);
        t2=findViewById(R.id.tj2);
        t3=findViewById(R.id.tj3);
        t4=findViewById(R.id.tj4);
        t5=findViewById(R.id.tj5);
        t6=findViewById(R.id.tj6);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("sliderval");
                String s=t1.getText().toString().trim();
                Intent two=new Intent(questwo.this,questhree.class);
                two.putExtra("ques1",one.toString().trim());
                two.putExtra( "ques2",s.toString().trim());
                startActivity(two);

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("sliderval");
                String s=t2.getText().toString().trim();
                Intent a=new Intent(questwo.this,questhree.class);
                a.putExtra("ques1",one.toString().trim());
                a.putExtra( "ques2",s.toString().trim());
                startActivity(a);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("sliderval");
                String s=t3.getText().toString().trim();
                Intent b=new Intent(questwo.this,questhree.class);
                b.putExtra("ques1",one.toString().trim());
                b.putExtra( "ques2",s.toString().trim());
                startActivity(b);

            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("sliderval");
                String s=t4.getText().toString().trim();
                Intent c=new Intent(questwo.this,questhree.class);
                c.putExtra("ques1",one.toString().trim());
                c.putExtra( "ques2",s.toString().trim());
                startActivity(c);

            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("sliderval");
                String s=t5.getText().toString().trim();
                Intent d=new Intent(questwo.this,questhree.class);
                d.putExtra("ques1",one.toString().trim());
                d.putExtra( "ques2",s.toString().trim());
                startActivity(d);

            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("sliderval");
                String s=t6.getText().toString().trim();
                Intent e=new Intent(questwo.this,questhree.class);
                e.putExtra("ques1",one.toString().trim());
                e.putExtra( "ques2",s.toString().trim());
                startActivity(e);

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"please choose any of the above",Toast.LENGTH_LONG).show();

            }
        });
    }
}