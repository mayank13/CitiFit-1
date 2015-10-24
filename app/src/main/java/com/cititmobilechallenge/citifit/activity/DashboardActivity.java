package com.cititmobilechallenge.citifit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cititmobilechallenge.citifit.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    private LineChart mChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mChart = (LineChart) findViewById(R.id.chart1);

        mChart = (LineChart) findViewById(R.id.chart1);

        // no description text
        mChart.setDescription("");
        mChart.setNoDataTextDescription("You need to provide data for the chart.");
        setWeeklyData();
    }

    private void setWeeklyData(){
        ArrayList<Entry> step_data = new ArrayList<Entry>();
        Entry c1e1 = new Entry(100.000f, 0); // 0 == quarter 1
        step_data.add(c1e1);
        Entry c1e2 = new Entry(50.000f, 1); // 1 == quarter 2 ...
        step_data.add(c1e2);
        LineDataSet weeklyData = new LineDataSet(step_data,"Weekly Data");

        // create a data object with the datasets
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("1.Q"); xVals.add("2.Q");
        LineData data = new LineData(xVals, weeklyData);

        // set data
        mChart.setData(data);
        mChart.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
