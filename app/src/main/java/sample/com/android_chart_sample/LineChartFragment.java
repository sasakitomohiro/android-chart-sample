package sample.com.android_chart_sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class LineChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart_line, container, false);
        int x = 1, y = 3;
        LineChart lineChart = (LineChart)view.findViewById(R.id.line_chart);
        LineDataSet dataSet;
        LineData data;
        List<Entry> entries = new ArrayList<>();

        for (int j = 0; j < 100; j++) {
            entries.add(new Entry(x * j, y * (float)(Math.random() * 20)));
        }

        dataSet = new LineDataSet(entries, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        data = new LineData(dataSet);
        lineChart.setData(data);
        lineChart.invalidate();
        return view;
    }
}