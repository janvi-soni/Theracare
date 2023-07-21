package com.example.mittihub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class journal_entry extends AppCompatActivity implements AdapterView.OnItemSelectedListener
        //implements AdapterView.OnItemSelectedListener
{
    String[] country = { "No Prompt", "x", "y", "z"};
    Button btnj;
    EditText e;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_entry);

        btnj=findViewById(R.id.btnj);
        e=findViewById(R.id.e);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        db = FirebaseFirestore.getInstance();

        btnj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String journal = e.getText().toString();
                if (TextUtils.isEmpty(journal)) {
                    Toast.makeText(getApplicationContext(), "enter the required fields", Toast.LENGTH_LONG).show();
                } else {
                    Map<String, Object> user = new HashMap<>();
                    user.put("Journalss", journal);


                    db.collection("Journals")
                            .add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {

                                    Toast.makeText(journal_entry.this, "Successfully added data to firestore", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull @NotNull Exception e) {

                                    Toast.makeText(journal_entry.this, "Failed", Toast.LENGTH_SHORT).show();


                                }
                            });
                }
            }
        });




        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spin.setAdapter(aa);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),country[position],Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}