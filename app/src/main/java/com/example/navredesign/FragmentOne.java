package com.example.navredesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentOne extends Fragment {

    View view;
    RecyclerView recyclerView;
    List<Item> items;

    public FragmentOne() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
//        recyclerView = view.findViewById(R.id.frag_one_recycler_view);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),items);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items = new ArrayList<>();
        items.add(new Item("Item no 1: ", "one"));
        items.add(new Item("Item no 2: ", "two"));
        items.add(new Item("Item no 3: ", "three"));
        items.add(new Item("Item no 4: ", "four"));
        items.add(new Item("Item no 5: ", "five"));
        items.add(new Item("Item no 6: ", "six"));
        items.add(new Item("Item no 7: ", "seven"));
        items.add(new Item("Item no 1: ", "one"));
        items.add(new Item("Item no 2: ", "two"));
        items.add(new Item("Item no 3: ", "three"));
        items.add(new Item("Item no 4: ", "four"));
        items.add(new Item("Item no 5: ", "five"));
        items.add(new Item("Item no 6: ", "six"));
        items.add(new Item("Item no 7: ", "seven"));


    }
}
