package com.example.navredesign.com.example.navredesign.fragment.navigation;

import android.annotation.SuppressLint;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.navredesign.BuildConfig;
import com.example.navredesign.MainContentActivity;
import com.example.navredesign.R;
import com.example.navredesign.com.example.navredesign.fragment.FragmentActionCenter;
import com.example.navredesign.com.example.navredesign.fragment.FragmentHome;
import com.example.navredesign.com.example.navredesign.fragment.FragmentMedicalCost;
import com.example.navredesign.com.example.navredesign.fragment.FragmentPerformance;
import com.example.navredesign.com.example.navredesign.fragment.FragmentPopulation;
import com.example.navredesign.com.example.navredesign.fragment.FragmentScorecard;
import com.example.navredesign.com.example.navredesign.fragment.FragmentScorecardTrending;
import com.example.navredesign.com.example.navredesign.fragment.FragmentSummary;
import com.example.navredesign.com.example.navredesign.fragment.FragmentYoY;

/**
 * @author msahakyan
 */

public class FragmentNavigationManager implements NavigationManager {

    private static FragmentNavigationManager sInstance;

    private FragmentManager mFragmentManager;
    private MainContentActivity mActivity;

    public static FragmentNavigationManager obtain(MainContentActivity activity) {
        if (sInstance == null) {
            sInstance = new FragmentNavigationManager();
        }
        sInstance.configure(activity);
        return sInstance;
    }

    private void configure(MainContentActivity activity) {
        mActivity = activity;
        mFragmentManager = mActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragmentHome(String title) {
        showFragment(FragmentHome.newInstance(title), false);
    }

    @Override
    public void showFragmentPopulation(String title) {
        showFragment(FragmentPopulation.newInstance(title), false);
    }

    @Override
    public void showFragmentPerformance(String title) {
        showFragment(FragmentPerformance.newInstance(title), false);
    }

    @Override
    public void showFragmentActionCenter(String title) {
        showFragment(FragmentActionCenter.newInstance(title), false);
    }

    @Override
    public void showFragmentMedicalCost(String title) {
        showFragment(FragmentMedicalCost.newInstance(title), false);
    }

    @Override
    public void showFragmentYoY(String title) {
        showFragment(FragmentYoY.newInstance(title), false);
    }

    @Override
    public void showFragmentScorecardTrending(String title) {
        showFragment(FragmentScorecardTrending.newInstance(title), false);
    }

    @Override
    public void showFragmentScorecard(String title) {
        showFragment(FragmentScorecard.newInstance(title), false);
    }

    @Override
    public void showFragmentSummary(String title) {
        showFragment(FragmentSummary.newInstance(title), false);
    }


    private void showFragment(Fragment fragment, boolean allowStateLoss) {
        FragmentManager fm = mFragmentManager;

        @SuppressLint("CommitTransaction")
        FragmentTransaction ft = fm.beginTransaction()
                .replace(R.id.nav_host_fragment,fragment);

        ft.addToBackStack(null);

        if (allowStateLoss || !BuildConfig.DEBUG) {
            ft.commitAllowingStateLoss();
        } else {
            ft.commit();
        }

        fm.executePendingTransactions();
    }
}
