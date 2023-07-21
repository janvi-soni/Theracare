package com.example.mittihub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class mind extends Fragment {
    CardView m1,m2,m3,m4,m5,m6,m7,m8;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mind, container, false);
        m1=view.findViewById(R.id.m1);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), work_life_balance.class);
                startActivity(intent);

            }
        });
        m2=view.findViewById(R.id.m2);
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), daily_stress.class);
                startActivity(intent);

            }
        });
        m3=view.findViewById(R.id.m3);
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), daily_frustation.class);
                startActivity(intent);

            }
        });
        m4=view.findViewById(R.id.m4);
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), slowing_down.class);
                startActivity(intent);

            }
        });
        m5=view.findViewById(R.id.m5);
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), slowing_down.class);
                startActivity(intent);

            }
        });
        m6=view.findViewById(R.id.m6);
        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),daily_frustation.class);
                startActivity(intent);

            }
        });
        m7=view.findViewById(R.id.m7);
        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), daily_stress.class);
                startActivity(intent);

            }
        });
        m8=view.findViewById(R.id.m8);
        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),work_life_balance.class);
                startActivity(intent);

            }
        });

        return view;

    }
}