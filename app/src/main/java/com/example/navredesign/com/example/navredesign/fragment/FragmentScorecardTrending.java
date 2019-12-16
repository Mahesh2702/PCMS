package com.example.navredesign.com.example.navredesign.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navredesign.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class FragmentScorecardTrending extends Fragment {

    //    private static final String KEY_MOVIE_TITLE = "key_title";

    private LineChart lineChart;
    Dialog myDialog;

    public static FragmentScorecardTrending newInstance(String title) {
        
        Bundle args = new Bundle();
        //        args.putString(KEY_MOVIE_TITLE, title);
        FragmentScorecardTrending fragment = new FragmentScorecardTrending();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_scorecardtrending, container, false);
        View view =  inflater.inflate(R.layout.fragment_scorecardtrending, container, false);
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        lineChart = view.findViewById(R.id.lineChart);
        LineDataSet lineDataSet1 = new LineDataSet(getEntries1(), "Top Group");
        LineDataSet lineDataSet2 = new LineDataSet(getEntries2(), "My Group");
        LineDataSet lineDataSet3 = new LineDataSet(getEntries3(), "Avg Group");
        lineDataSet1.setLineWidth(2);
        lineDataSet1.setColor(Color.YELLOW);

        lineDataSet2.setLineWidth(2);
        lineDataSet2.setColor(Color.GREEN);

        lineDataSet3.setLineWidth(2);
        lineDataSet3.setColor(Color.BLUE);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);
        dataSets.add(lineDataSet3);
        LineData lineData = new LineData(dataSets);
        lineChart.getAxisLeft().setValueFormatter(new PercentFormatter());
        lineChart.getXAxis().setAxisLineWidth(2);
        lineChart.getXAxis().setAxisMinimum(0);
        lineChart.getXAxis().setAxisMaximum(11);
        lineChart.getAxisLeft().setAxisLineWidth(2);
        lineChart.getAxisLeft().setAxisMinimum(0);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getDescription().setEnabled(false);
        Legend legend = lineChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);

        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    private ArrayList<Entry> getEntries1() {
        ArrayList<Entry> lineEntries = new ArrayList<>() ;
        lineEntries.add(new Entry(3, 28));
        lineEntries.add(new Entry(4, 12));
        lineEntries.add(new Entry(5, 30));
        lineEntries.add(new Entry(6, 30));
        return lineEntries;
    }

    private ArrayList<Entry> getEntries2() {
        ArrayList<Entry> lineEntries = new ArrayList<>() ;
        lineEntries.add(new Entry(3, 19));
        lineEntries.add(new Entry(4, 5));
        lineEntries.add(new Entry(5, 21));
        lineEntries.add(new Entry(6, 22));
        return lineEntries;
    }

    private ArrayList<Entry> getEntries3() {
        ArrayList<Entry> lineEntries = new ArrayList<>() ;
        lineEntries.add(new Entry(3, 13));
        lineEntries.add(new Entry(4, 11));
        lineEntries.add(new Entry(5, 17));
        lineEntries.add(new Entry(6, 18));
        return lineEntries;
    }


}
