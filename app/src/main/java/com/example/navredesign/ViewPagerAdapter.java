package com.example.navredesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
//    Context context;

    private final List<Fragment> listFragment = new ArrayList<>();
    private final List<String> listTitles = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

//    public ViewPagerAdapter(Context context, @NonNull FragmentManager fm) {
//        super(fm);
//        this.context = context;
//    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }

    public void addFragment(Fragment fm, String title){
        listFragment.add(fm);
        listTitles.add(title);
    }

    public View getTabView(int position, List<TabTitle> tabTitles, Context context) {
        PieProgressDrawable pieProgressDrawable = new PieProgressDrawable();
        pieProgressDrawable.setColor(ContextCompat.getColor(context, R.color.pcmsPrmryLight));
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab_layout, null);
        TextView tvTabTitle = (TextView) v.findViewById(R.id.tv_tabTitle);
        tvTabTitle.setText(tabTitles.get(position).getTabTitle());
        TextView tvTabSubTitle = (TextView) v.findViewById(R.id.tv_tabSubTitle);
        tvTabSubTitle.setText(tabTitles.get(position).getTabSubTitle());
        ImageView timeProgress = (ImageView) v.findViewById(R.id.time_progress);
        timeProgress.invalidate();
        System.out.println(tabTitles.get(position).getProgress());
        timeProgress.setImageDrawable(pieProgressDrawable);
        pieProgressDrawable.setLevel(tabTitles.get(position).getProgress());
        timeProgress.invalidate();
        return v;
    }
}
