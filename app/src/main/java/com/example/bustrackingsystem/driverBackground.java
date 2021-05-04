package com.example.bustrackingsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class driverBackground extends AsyncTask <String  , Void , String> {

    public String status = "Login Status";



    AlertDialog dialog;
    Context context;
    public driverBackground(Context context){

        this.context = context;
    }

    @Override
    protected void onPreExecute() {
       dialog = new AlertDialog.Builder(context).create();

       dialog.setTitle(status );


    }

    @Override
    protected void onPostExecute(String s) {

        if(s.equals("This email is not valid") ||s.matches("Host unreachable")  || s.equals("Wrong Password") || s.matches("failed to connect to (.*)") ||s.matches("The Email-id is not Registerd") || s.matches("Cleartext HTTP traffic to (.*)") ){
            dialog.setMessage(s);
            dialog.show();
        }
        else{
            dialog.setMessage(s);
            dialog.show();
            DriverMain2Activity.openNewActivity();
        }




    }

    @Override
    protected String doInBackground(String... voids) {

       String result = "";

       String email = voids[0];
       String password = voids[1];

       AppStartActivity.getEmail(email);

       String conn = "  ";

        try {
            URL url = new URL(conn);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");;
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")
                    +"&&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            String line = "";
            while ((line = reader.readLine()) != null){
                result += line;
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;


        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }


        return result;


    }
}
