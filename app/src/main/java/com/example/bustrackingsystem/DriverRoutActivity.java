package com.example.bustrackingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DriverRoutActivity extends AppCompatActivity {
    ListView routList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_rout);

        routList = findViewById(R.id.lv_driverRoutList);
        String[] routs = {   };





    }
}
