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

public class FragmentTwo extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<CardItem> cardItemList;

    public FragmentTwo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerView = view.findViewById(R.id.frag_one_recycler_view);
        CardItemRecyclerViewAdapter recyclerViewAdapter = new CardItemRecyclerViewAdapter(getContext(),cardItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem("Adult Prevention 1", 20.04, 20.04));
        cardItemList.add(new CardItem("Pediatric Prevention 2", 10.04, 18.06));
        cardItemList.add(new CardItem("Other Prevention 3", 5.01, 8.50));
        cardItemList.add(new CardItem("Adult Prevention 4", 13.07, 15.06));
        cardItemList.add(new CardItem("Pediatric Prevention 5", 7.50, 10.00));
        cardItemList.add(new CardItem("Other Prevention 6", 3.05, 10.04));
        cardItemList.add(new CardItem("Adult Prevention 1", 20.04, 20.04));
        cardItemList.add(new CardItem("Pediatric Prevention 2", 10.04, 18.06));
        cardItemList.add(new CardItem("Other Prevention 3", 5.01, 8.50));
        cardItemList.add(new CardItem("Adult Prevention 4", 13.07, 15.06));
        cardItemList.add(new CardItem("Pediatric Prevention 5", 7.50, 10.00));
        cardItemList.add(new CardItem("Other Prevention 6", 3.05, 10.04));
        cardItemList.add(new CardItem("Adult Prevention 1", 20.04, 20.04));
        cardItemList.add(new CardItem("Pediatric Prevention 2", 10.04, 18.06));
        cardItemList.add(new CardItem("Other Prevention 3", 5.01, 8.50));
        cardItemList.add(new CardItem("Adult Prevention 4", 13.07, 15.06));
        cardItemList.add(new CardItem("Pediatric Prevention 5", 7.50, 10.00));
        cardItemList.add(new CardItem("Other Prevention 6", 3.05, 10.04));
    }
}
