package sample.com.android_chart_sample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(viewPagerAdapter);
        TabLayout tableLayout = findViewById(R.id.tab_layout);
        tableLayout.setupWithViewPager(viewPager);
    }

    private static class ViewPagerAdapter extends FragmentPagerAdapter {
        CharSequence[] titles = {"bar", "pie", "line"};
        ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            Bundle bundle = new Bundle();
            bundle.putString("chart", titles[position].toString());
            switch (titles[position].toString()) {
                case "bar":
                    fragment = new BarChartFragment();
                    break;
                case "pie":
                    fragment = new PieChartFragment();
                    break;
                case "line":
                    fragment = new LineChartFragment();
                    break;
                default:
                    fragment = new BarChartFragment();
            }
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
