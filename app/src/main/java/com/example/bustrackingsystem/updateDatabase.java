package com.example.bustrackingsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

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

public class updateDatabase extends AsyncTask <String , Void, String> {

    Context context;
    String putRoutIntoDb;

    updateDatabase(Context context){
        this.context=context;
    }

    protected void onPreExecute() {
        Log.d("Before update","before update");


    }


    protected void onPostExecute(String s) {

        Log.d("result",s);

return;
    }


    protected String doInBackground(String... strings) {

        String result = "";
        String email = strings[0];
        String latitude = strings[1];
        String longitude = strings[2];
        String rout = strings[3];





        String databaseURl = "  ";

        try{
            URL url = new URL(databaseURl);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String postData = URLEncoder.encode("driver","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                   + URLEncoder.encode("alatitude","UTF-8")+"="+URLEncoder.encode(latitude,"UTF-8")+"&"
                    + URLEncoder.encode("alongitude","UTF-8")+"="+URLEncoder.encode(longitude,"UTF-8")+"&"
                    + URLEncoder.encode("aRout","UTF-8")+"="+URLEncoder.encode(putRoutIntoDb ,"UTF-8");
            bufferedWriter.write(postData);
            bufferedWriter.flush();
            bufferedWriter.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String line = "";
            while ((line = bufferedReader.readLine())!= null){
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            return result;

        }catch (MalformedURLException e){
            result = e.getMessage();

        }catch (IOException e){

            result= e.getMessage();

        }
        return result;
    }
}
