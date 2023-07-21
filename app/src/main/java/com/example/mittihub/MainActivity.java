package com.example.mittihub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView2);
        navigationView.getMenu();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment selected = new home();
                switch (id) {
                    case R.id.home:
                        selected = new home();
                        break;
                    case R.id.mind:
                        selected = new mind();
                        break;
                    case R.id.coaching:
                        selected = new coaching();
                        break;
                    case R.id.journal:
                        selected = new journal();
                        break;
                    case R.id.peers:
                        selected = new peers();
                        break;
                    default:
                        selected = new home();


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.myframe,
                        selected).commit();
                return true;
            }
        });
    }
//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            // Inflate the menu; this adds items to the action bar if it is present.
//            getMenuInflater().inflate(R.menu.opmenu, menu);
//            return true;
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            int id = item.getItemId();
//            switch (id) {
//                case R.id.profile:
//                    Intent j = new Intent(MainActivity.this, profile.class);
//                    startActivity(j);
//                    return true;
//                case R.id.privacy:
//                    Intent k = new Intent(MainActivity.this,PrivacyPolicy.class);
//                    startActivity(k);
//                    return true;
//                case R.id.terms:
//                    Toast.makeText(getApplicationContext(),"this is terms of use",Toast.LENGTH_LONG).show();
//                    return true;
//                case R.id.ana:
//                        Uri webpage = Uri.parse("http://therecare.co/");
//                        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
//                        startActivity(webIntent);
//                        return true;
//                case R.id.contact:
//                       new fragmentdialogbox().show(getSupportFragmentManager(),"fragmentdialog");
//                        return true;
//
//                default:
//                    return super.onOptionsItemSelected(item);
//            }
//        }



    }

