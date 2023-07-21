package com.example.mittihub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public class meetcoach extends AppCompatActivity {
    Button b;
    EditText ed;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetcoach);
        ed=findViewById(R.id.meeted);
        db = FirebaseFirestore.getInstance();

        b=findViewById(R.id.customDialog);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
                String email = users.getEmail();
                String edd=ed.getText().toString();
                if (TextUtils.isEmpty(edd))
                {
                    Toast.makeText(getApplicationContext(), "enter the required fields", Toast.LENGTH_LONG).show();
                }
                else {
                    Map<String, Object> user = new HashMap<>();
                    user.put("User",email);
                    user.put("Msg",edd);

                    db.collection("Meet_coach_data")
                            .add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {

                                    Toast.makeText(meetcoach.this, "Successfully added data to firestore", Toast.LENGTH_SHORT).show();
                                    final AlertDialog.Builder builder = new AlertDialog.Builder(meetcoach.this,R.style.CustomAlertDialog);
                                    ViewGroup viewGroup = findViewById(android.R.id.content);
                                    View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.customview, viewGroup, false);
                                    Button buttonOk=dialogView.findViewById(R.id.buttonOk);
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

                                    Toast.makeText(meetcoach.this, "Failed", Toast.LENGTH_SHORT).show();


                                }
                            });

                }
            }
        });

    }
}

