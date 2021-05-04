package com.example.bustrackingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {
    Button btn_driver,btn_client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        btn_driver = findViewById(R.id.btn_driver) ;
        btn_client = findViewById(R.id.btn_client) ;




        btn_driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectionActivity.this,DriverMain2Activity.class);
                startActivity(i);

            }
        });


    }
}
