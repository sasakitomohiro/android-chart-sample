package sample.com.android_chart_sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class PieChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart_pie, container, false);
        int x = 1, y = 3;
        PieChart lineChart = (PieChart) view.findViewById(R.id.pie_chart);
        PieDataSet dataSet;
        PieData data;
        List<PieEntry> entries = new ArrayList<>();

        for (int j = 0; j < 10; j++) {
            entries.add(new PieEntry(x * j, y * (float)(Math.random() * 20)));
        }

        dataSet = new PieDataSet(entries, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        data = new PieData(dataSet);
        lineChart.setData(data);
        lineChart.invalidate();
        return view;
    }
}