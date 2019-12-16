package com.example.navredesign.com.example.navredesign.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navredesign.R;

public class FragmentSummary extends Fragment {

//    private final static String KEY_TITLE = "key_title";
    Dialog myDialog;

    public static FragmentSummary newInstance(String title) {

        Bundle args = new Bundle();
//        args.putString(KEY_TITLE, title);
        FragmentSummary fragment = new FragmentSummary();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_summary, container, false);
        myDialog = new Dialog(getContext());
        Button filterBtn = (Button)view.findViewById(R.id.filterBtn);
        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton closeBtn;
                Button btnFollow;
                myDialog.setContentView(R.layout.filter_window);
                closeBtn =(ImageButton) myDialog.findViewById(R.id.closeBtn);
                closeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
            }
        });


//        Spinner aSpinner = view.findViewById(R.id.aSpinner);
//        aSpinner.setOnItemSelectedListener(this);
//
//        Spinner simpleSpinner = view.findViewById(R.id.simpleSpinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                getContext(),
//                R.array.Spinner_items,
//                android.R.layout.simple_spinner_item
//        );
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        simpleSpinner.setAdapter(adapter);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


}
