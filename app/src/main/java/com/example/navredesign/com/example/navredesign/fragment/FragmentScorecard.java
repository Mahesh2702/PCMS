package com.example.navredesign.com.example.navredesign.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.navredesign.FragmentOne;
import com.example.navredesign.FragmentThree;
import com.example.navredesign.FragmentTwo;
import com.example.navredesign.PieProgressDrawable;
import com.example.navredesign.R;
import com.example.navredesign.TabTitle;
import com.example.navredesign.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FragmentScorecard extends Fragment {

    //    private static final String KEY_MOVIE_TITLE = "key_title";
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;
    List<TabTitle> tabTitleList = new ArrayList<TabTitle>();
    Dialog myDialog;

    public static FragmentScorecard newInstance(String title) {

        Bundle args = new Bundle();
//        args.putString(KEY_MOVIE_TITLE,title);
        FragmentScorecard fragment = new FragmentScorecard();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_scorecard, container, false);
        View view =  inflater.inflate(R.layout.fragment_scorecard, container, false);
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
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        tabLayout = view.findViewById(R.id.tabLayout1);
        viewPager = view.findViewById(R.id.viewPager1);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

//        viewPagerAdapter.addFragment(new FragmentOne(),"One");
        viewPagerAdapter.addFragment(new FragmentTwo(), "Preventive Care");
        viewPagerAdapter.addFragment(new FragmentThree(), "Standard");
        viewPagerAdapter.addFragment(new FragmentThree(), "Standard");

        tabTitleList.add(new TabTitle("Preventive Care", 20.14, 20.18));
        tabTitleList.add(new TabTitle("Standard", 23.34, 50.14));
        tabTitleList.add(new TabTitle("Standard", 23.34, 50.14));

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(viewPagerAdapter.getTabView(i, tabTitleList, getActivity().getApplicationContext()));
        }

    }

}

