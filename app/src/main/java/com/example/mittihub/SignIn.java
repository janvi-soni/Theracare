package com.example.mittihub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    TextView t,tr;
    FirebaseAuth authi;
    EditText x,y;
    Button m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authi= FirebaseAuth.getInstance();
        if (authi.getCurrentUser()!=null) {
            Intent j = new Intent(SignIn.this,MainActivity.class);
            startActivity(j);
            finish();
        }
        else
        {
            setContentView(R.layout.activity_sign_in);
            t=findViewById(R.id.t);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent k = new Intent(SignIn.this, forgot.class);
                    startActivity(k);
                    finish();
                }
            });
            x=findViewById(R.id.edt1);
            y=findViewById(R.id.edt2);
            m=findViewById(R.id.btn1);
            tr=findViewById(R.id.tvreg);
            tr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent j = new Intent(SignIn.this,Signup.class);
                    startActivity(j);
                    finish();
                }


            });

            m.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = x.getText().toString().trim();
                    String password = y.getText().toString().trim();
                    if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                        Toast.makeText(getApplicationContext(), "please enter the required fields", Toast.LENGTH_LONG).show();
                    } else {
                        authi.signInWithEmailAndPassword(email, password).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if ((!task.isSuccessful())) {
                                    Toast.makeText(getApplicationContext(), "error occured while signing", Toast.LENGTH_LONG).show();
                                } else {
                                    Intent j = new Intent(SignIn.this, MainActivity.class);
                                    startActivity(j);
                                    finish();
                                }
                            }


                        });
                    }
                }
            });



        }
    }


}