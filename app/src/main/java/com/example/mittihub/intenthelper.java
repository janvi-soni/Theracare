package com.example.mittihub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class intenthelper extends AppCompatActivity {
    String one, two, three;
    FirebaseFirestore db;
    Button bt;
//



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intenthelper);
        bt=findViewById(R.id.bt);
        db = FirebaseFirestore.getInstance();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one = getIntent().getStringExtra("ques1");
                two = getIntent().getStringExtra("ques2");
                three = getIntent().getStringExtra("ques3");
                FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
                String email = users.getEmail();
                Map<String, Object> user = new HashMap<>();
                user.put("User", email);
                user.put("ques1", one);
                user.put("ques2", two);
                user.put("ques3", three);


                db.collection("how was your day data")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {

                                Toast.makeText(intenthelper.this, "Successfully added data to firestore", Toast.LENGTH_SHORT).show();
                                final AlertDialog.Builder builder = new AlertDialog.Builder(intenthelper.this, R.style.CustomAlertDialog);
                                ViewGroup viewGroup = findViewById(android.R.id.content);
                                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.customview, viewGroup, false);
                                Button buttonOk = dialogView.findViewById(R.id.buttonOk);
                                builder.setView(dialogView);
                                final AlertDialog alertDialog = builder.create();
                                buttonOk.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        alertDialog.dismiss();
                                    }
                                });
                                alertDialog.show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @NotNull Exception e) {

                                Toast.makeText(intenthelper.this, "Failed", Toast.LENGTH_SHORT).show();


                            }
                        });
            }
        });

    }
}



