package com.example.mittihub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class questhree extends AppCompatActivity {
    TextView bq;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questhree);
//
        bq = findViewById(R.id.bq);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("ques1");
                String two = getIntent().getStringExtra("ques2");
                String s=t1.getText().toString().trim();
                Intent z=new Intent(questhree.this,intenthelper.class);
                z.putExtra( "ques1",one.toString().trim());
                z.putExtra( "ques2",two.toString().trim());
                z.putExtra( "ques3",s.toString().trim());
                startActivity(z);

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("ques1");
                String two = getIntent().getStringExtra("ques2");
                String s=t2.getText().toString().trim();
                Intent a=new Intent(questhree.this,intenthelper.class);
                a.putExtra( "ques1",one.toString().trim());
                a.putExtra( "ques2",two.toString().trim());
                a.putExtra( "ques3",s.toString().trim());
                startActivity(a);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("ques1");
                String two = getIntent().getStringExtra("ques2");
                String s=t3.getText().toString().trim();
                Intent b=new Intent(questhree.this,intenthelper.class);
                b.putExtra( "ques1",one.toString().trim());
                b.putExtra( "ques2",two.toString().trim());
                b.putExtra( "ques3",s.toString().trim());
                startActivity(b);

            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("ques1");
                String two = getIntent().getStringExtra("ques2");
                String s=t4.getText().toString().trim();
                Intent c=new Intent(questhree.this,intenthelper.class);
                c.putExtra( "ques1",one.toString().trim());
                c.putExtra( "ques2",two.toString().trim());
                c.putExtra( "ques3",s.toString().trim());
                startActivity(c);

            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("ques1");
                String two = getIntent().getStringExtra("ques2");
                String s=t5.getText().toString().trim();
                Intent d=new Intent(questhree.this,intenthelper.class);
                d.putExtra( "ques1",one.toString().trim());
                d.putExtra( "ques2",two.toString().trim());
                d.putExtra( "ques3",s.toString().trim());
                startActivity(d);

            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("ques1");
                String two = getIntent().getStringExtra("ques2");
                String s=t6.getText().toString().trim();
                Intent e=new Intent(questhree.this,intenthelper.class);
                e.putExtra( "ques1",one.toString().trim());
                e.putExtra( "ques2",two.toString().trim());
                e.putExtra( "ques3",s.toString().trim());
                startActivity(e);

            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = getIntent().getStringExtra("ques1");
                String two = getIntent().getStringExtra("ques2");

                String s=t7.getText().toString().trim();
                Intent f=new Intent(questhree.this,intenthelper.class);
                f.putExtra( "ques1",one.toString().trim());
                f.putExtra( "ques2",two.toString().trim());
                f.putExtra( "ques3",s.toString().trim());
                startActivity(f);

            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            String one = getIntent().getStringExtra("ques1");
            String two = getIntent().getStringExtra("ques2");
            @Override
            public void onClick(View v) {
                String s=t8.getText().toString().trim();
                Intent g=new Intent(questhree.this,intenthelper.class);
                g.putExtra( "ques1",one.toString().trim());
                g.putExtra( "ques2",two.toString().trim());
                g.putExtra( "ques3",s.toString().trim());
                startActivity(g);

            }
        });

        bq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"please choose any of the above",Toast.LENGTH_LONG).show();

            }
        });
    }
}

































































