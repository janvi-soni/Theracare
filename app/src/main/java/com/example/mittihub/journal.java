package com.example.mittihub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class journal extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton fab;
    janadap adapterr;
    ArrayList<janmodal> minfolist;
    FirebaseFirestore db;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_journal, container, false);
        recyclerView=view.findViewById(R.id.r);
        fab = view.findViewById(R.id.fab);
        db = FirebaseFirestore.getInstance();
        minfolist = new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapterr = new janadap(getActivity(),minfolist);

        recyclerView.setAdapter(adapterr);

        db.collection("Journals")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            //if (progressDialog.isShowing())
                            //   progressDialog.dismiss();
                            Log.e("Firestore errror", error.getMessage());
                            return;

                        }

                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                minfolist.add(dc.getDocument().toObject(janmodal.class));
                            }
                            adapterr.notifyDataSetChanged();
                            // if (progressDialog.isShowing())
                            //   progressDialog.dismiss();
                        }
                    }


                });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mood.class);
                startActivity(intent);

            }
        });


        return  view;

    }
}


