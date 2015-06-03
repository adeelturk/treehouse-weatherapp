package com.example.ian.treehouseweatherapp.UI;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.ian.treehouseweatherapp.R;
import com.example.ian.treehouseweatherapp.adapters.DayAdapter;
import com.example.ian.treehouseweatherapp.weather.Day;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        DayAdapter adapter = new DayAdapter(this, mDays);
    }

}
