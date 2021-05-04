package com.example.bustrackingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;






public class ClientMainActivity extends AppCompatActivity {

    private static Context mContext;

    MaterialEditText email,password;


    Button rigister ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_activity_main);
        email =  findViewById(R.id.edt_logEmail);
        password = findViewById(R.id.edt_logPassword);
        rigister =  findViewById(R.id.btn_newRigister);
        mContext = this;


        rigister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClientMainActivity.this,RigisterActivity.class);
                startActivity(i);
                finish();
            }
        });



    }

    public static void openNewActivity(){

        Intent i = new Intent(mContext.getApplicationContext(),ClientRoutActivity.class);
        mContext.startActivity(i);

    }



    public void loginBtn(View view) {
        String getEmail = email.getText().toString();
        String getPassword = password.getText().toString();




        if(TextUtils.isEmpty(getEmail) || TextUtils.isEmpty(getPassword)){
            Toast.makeText(getApplicationContext(),"All Firlds are Reqired",Toast.LENGTH_SHORT).show();
        }
        else {
            Background bg = new Background(this);
            bg.execute(getEmail,getPassword);

        }


    }

    private static class ClientRoutActivity {
    }
}

