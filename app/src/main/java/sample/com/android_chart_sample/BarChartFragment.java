package sample.com.android_chart_sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BarChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart_bar, container, false);
        int x = 1, y = 3;
        BarChart lineChart = (BarChart)view.findViewById(R.id.bar_chart);
        BarDataSet dataSet;
        BarData data;
        List<BarEntry> entries = new ArrayList<>();

        for (int j = 0; j < 100; j++) {
            entries.add(new BarEntry(x * j, y * (float)(Math.random() * 20)));
        }

        dataSet = new BarDataSet(entries, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        data = new BarData(dataSet);
        lineChart.setData(data);
        lineChart.invalidate();
        return view;
    }
}