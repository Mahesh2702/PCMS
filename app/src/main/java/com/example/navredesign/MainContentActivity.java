package com.example.navredesign;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import com.example.navredesign.com.example.navredesign.fragment.navigation.FragmentNavigationManager;
import com.example.navredesign.com.example.navredesign.fragment.navigation.NavigationManager;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.ui.AppBarConfiguration;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class MainContentActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    List<GroupParentItem> listDataHeader;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    Toolbar toolbar;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private NavigationManager mNavigationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maincontent);
        expandableListView = findViewById(R.id.lvExp);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        prepareListData();
        addDrawerItems();
        setupDrawer();

        mNavigationManager = FragmentNavigationManager.obtain(this);
        mNavigationManager.showFragmentHome("Home");
    }

    private void addDrawerItems() {
        expandableListAdapter = new ExpandableListAdapter(this, listDataHeader);
        expandableListView.setAdapter(expandableListAdapter);
        getSupportActionBar().setTitle(listDataHeader.get(0).getName());
        getSupportActionBar().setIcon(listDataHeader.get(0).getFlag());

//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                getSupportActionBar().setTitle(listDataHeader.get(groupPosition).getName().toString());
//            }
//        });

//        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                getSupportActionBar().setTitle(R.string.film_genres);
//            }
//        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                GroupParentItem selectedGroup  = ((GroupParentItem) (listDataHeader.get(groupPosition)));
                if(selectedGroup.getChildList().size() == 0){
                    getSupportActionBar().setTitle(listDataHeader.get(groupPosition).getName());
                    getSupportActionBar().setIcon(listDataHeader.get(groupPosition).getFlag());
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }
                switch (selectedGroup.getName()){
                    case "Home":
                        mNavigationManager.showFragmentHome(selectedGroup.getName());
                        break;
                    case "Population":
                        mNavigationManager.showFragmentPopulation(selectedGroup.getName());
                        break;
                    case "Performance":
                        mNavigationManager.showFragmentPerformance(selectedGroup.getName());
                        break;
                    case "Action center":
                        mNavigationManager.showFragmentActionCenter(selectedGroup.getName());
                        break;
                    default:
                        mNavigationManager.showFragmentHome(selectedGroup.getName());
                        break;

                }
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String selectedItem = ((GroupParentItem) (listDataHeader.get(groupPosition)))
                        .getChildList().get(childPosition).toString();
                getSupportActionBar().setTitle(listDataHeader.get(groupPosition).getName());
                getSupportActionBar().setIcon(listDataHeader.get(groupPosition).getFlag());
                    System.out.println(selectedItem+" "+ listDataHeader.get(groupPosition).getName());
                if ("Summary".equals(selectedItem)) {
                    mNavigationManager.showFragmentSummary(selectedItem);
                }
                else if ("Scorecard Trending".equals(selectedItem)) {
                    mNavigationManager.showFragmentScorecardTrending(selectedItem);
                }
                else if ("Scorecard".equals(selectedItem)) {
                    mNavigationManager.showFragmentScorecard(selectedItem);
                }
                else if ("Medical Cost".equals(selectedItem)) {
                    mNavigationManager.showFragmentMedicalCost(selectedItem);
                }
                else if ("YoY Performance".equals(selectedItem)) {
                    mNavigationManager.showFragmentYoY(selectedItem);
                }else {
                    throw new IllegalArgumentException("Not supported fragment type");
                }
//
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar ,R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                getSupportActionBar().setTitle(R.string.film_genres);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
//                getSupportActionBar().setTitle("abc");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<GroupParentItem>();

        List<String> home = new ArrayList<String>();
        List<String> population = new ArrayList<String>();
        List<String> actionCenter = new ArrayList<String>();

        List<String> performance = new ArrayList<String>();
        performance.add("Summary");
        performance.add("Scorecard");
        performance.add("Scorecard Trending");
        performance.add("Medical Cost");
        performance.add("YoY Performance");
        // Adding child data
        listDataHeader.add(new GroupParentItem("Home",R.drawable.ic_home_black_24dp, home));
        listDataHeader.add(new GroupParentItem("Population", R.drawable.ic_people_black_24dp,population));
        listDataHeader.add(new GroupParentItem("Performance", R.drawable.ic_trending_up_black_24dp,performance ));
        listDataHeader.add(new GroupParentItem("Action center", R.drawable.ic_rate_review_black_24dp, actionCenter));

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        expandableListView.setIndicatorBounds(expandableListView.getRight()- 120, expandableListView.getWidth());
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
