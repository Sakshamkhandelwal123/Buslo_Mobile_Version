package com.example.bustrackingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bustrackingsystem.sms.AccidentSms;
import com.example.bustrackingsystem.sms.BatteryLowSms;
import com.example.bustrackingsystem.sms.DamageSms;
import com.example.bustrackingsystem.sms.LongTraficSms;
import com.example.bustrackingsystem.sms.PassangerHealthIssueSms;


public class EmergencyActivity extends AppCompatActivity {

    Button accident,damage,passangerHealthIssue,longTrafic,batteryLow ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        accident = findViewById(R.id.btn_accident);
        damage = findViewById(R.id.btn_damage);
        passangerHealthIssue = findViewById(R.id.btn_passhealthpro);
        longTrafic = findViewById(R.id._btn_longTrafic);
        batteryLow = findViewById(R.id.btn_batter_low);

        accident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AccidentSms accidentSms = new AccidentSms(getApplicationContext());
                accidentSms.sms();

            }
        });

        damage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DamageSms damageSms = new DamageSms(getApplicationContext());
                damageSms.sms();
            }
        });


        passangerHealthIssue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassangerHealthIssueSms passangerHealthIssueSms = new PassangerHealthIssueSms(getApplicationContext());
                passangerHealthIssueSms.sms();

            }
        });


        longTrafic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LongTraficSms longTraficSms = new LongTraficSms(getApplicationContext());
                longTraficSms.sms();

            }
        });

        batteryLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BatteryLowSms batteryLowSms = new BatteryLowSms(getApplicationContext());
                batteryLowSms.sms();

            }
        });




    }
}
