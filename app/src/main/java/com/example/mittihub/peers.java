package com.example.mittihub;

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
import android.widget.SearchView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class peers extends Fragment {
    RecyclerView recyclerView;
    viadapter adapter;
    ArrayList<Modalclassjo> infolist;
    FirebaseFirestore db;
    SearchView sv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_peers, container, false);
     recyclerView =view.findViewById(R.id.rv);
        db = FirebaseFirestore.getInstance();
         sv=view.findViewById(R.id.searchview);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        infolist = new ArrayList<>();
        adapter = new viadapter(getActivity().getApplicationContext(), infolist,this::onItemClick);
        recyclerView.setAdapter(adapter);


        db.collection("groups")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("Firestore errror", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                infolist.add(dc.getDocument().toObject(Modalclassjo.class));
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }


                });
        if(sv!=null)
        {
            sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }
    }

    private void search(String str) {
        ArrayList<Modalclassjo> mylist=new ArrayList<>();
        for(Modalclassjo obj:infolist)
        {
            if(obj.getgroup().toLowerCase().contains(str.toLowerCase()))
            {
                mylist.add(obj);

            }
        }
        viadapter viadapter=new viadapter(getActivity(),mylist,this::onItemClick);
        recyclerView.setAdapter(viadapter);

    }

    public void onItemClick(int position) {
        {
            Intent intent=new Intent(getActivity(),detailsactivity.class);
            intent.putExtra("Group",infolist.get(position).getgroup());
            intent.putExtra("Description",infolist.get(position).getDescription());
            intent.putExtra("Members",infolist.get(position).getMembers());
            startActivity(intent);



        }
    }


}