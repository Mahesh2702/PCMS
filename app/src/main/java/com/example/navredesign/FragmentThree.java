package com.example.navredesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentThree extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<CardItem2> cardItem2List;

    public FragmentThree() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        recyclerView = view.findViewById(R.id.frag_three_recycler_view);
        CardItem2RecyclerViewAdapter recyclerViewAdapter = new CardItem2RecyclerViewAdapter(getContext(),cardItem2List);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardItem2List = new ArrayList<>();
        cardItem2List.add(new CardItem2("Colateral cancer screening - (G)",0.00, 6.90, 60.18, 132, 175, 2));
        cardItem2List.add(new CardItem2("Diabetes care - Eye Exam - (G)",0.00, 6.90, 60.18, 132, 175, 1));
        cardItem2List.add(new CardItem2("Readmission Rate - (G)",6.90, 6.90, 0.00, 0, 0, 5));
        cardItem2List.add(new CardItem2("Colateral cancer screening - (G)",0.00, 6.90, 60.18, 132, 175, 2));
        cardItem2List.add(new CardItem2("Diabetes care - Eye Exam - (G)",0.00, 6.90, 60.18, 132, 175, 1));
        cardItem2List.add(new CardItem2("Readmission Rate - (G)",6.90, 6.90, 0.00, 0, 0, 5));
        cardItem2List.add(new CardItem2("Colateral cancer screening - (G)",0.00, 6.90, 60.18, 132, 175, 2));
        cardItem2List.add(new CardItem2("Diabetes care - Eye Exam - (G)",0.00, 6.90, 60.18, 132, 175, 1));
        cardItem2List.add(new CardItem2("Readmission Rate - (G)",6.90, 6.90, 0.00, 0, 0, 5));
        cardItem2List.add(new CardItem2("Colateral cancer screening - (G)",0.00, 6.90, 60.18, 132, 175, 2));
        cardItem2List.add(new CardItem2("Diabetes care - Eye Exam - (G)",0.00, 6.90, 60.18, 132, 175, 1));
        cardItem2List.add(new CardItem2("Readmission Rate - (G)",6.90, 6.90, 0.00, 0, 0, 5));

    }
}
