package com.example.mittihub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class home extends Fragment {
   TextView tv1,tv2,tw,tv3;
   CardView cj1,cv1,cv2,cv3,cv4;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);
       cj1=view.findViewById(R.id.cj1);
       cj1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Uri webpage = Uri.parse("http://therecare.co/");
               Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
               startActivity(webIntent);
           }
       });
       cv1=view.findViewById(R.id.cvsess1);
       cv1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), session1.class);
               startActivity(intent);

           }
       });
        cv2=view.findViewById(R.id.cvsess2);
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), session2.class);
                startActivity(intent);

            }
        });

        cv3=view.findViewById(R.id.cvsess3);
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), sesson3.class);
                startActivity(intent);

            }
        });

        cv4=view.findViewById(R.id.cvsess4);
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), session4.class);
                startActivity(intent);

            }
        });



        tv3=view.findViewById(R.id.tvexplore);
       tv1=view.findViewById(R.id.cctv1);
       tv2=view.findViewById(R.id.cctv2);
       tw=view.findViewById(R.id.tw);
        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), coaching.class);
                startActivity(intent);

            }
        });

       tv1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), meetcoach.class);
               startActivity(intent);

           }
       });
       tv2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),quesone.class);
               startActivity(intent);


           }
       });

       return view;
    }
}