package com.example.bustrackingsystem.sms;

import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

public class LongTraficSms {

    private Context context;
    public LongTraficSms(Context context){
        this.context=context;

    }
    public void sms() {


        String toPhoneNumber = "6362353971";
        String smsMessage = "Long Traffic May get Late to reach The Destination" ;
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(toPhoneNumber, null, smsMessage, null, null);
            Toast.makeText(context.getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context.getApplicationContext(),
                    "Sending SMS failed.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


}
