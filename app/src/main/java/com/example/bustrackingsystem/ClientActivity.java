package com.example.bustrackingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.Buffer;

public class ClientActivity extends AppCompatActivity {

    public static TextView driverName, latitude,longitude;
    Button map;
    TextView routName;
    String getRoutName;
    String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        latitude = findViewById(R.id.tv_setlat);
        longitude = findViewById(R.id.tv_setlongi);
        driverName = findViewById(R.id.tv_setDriverName);
        map =findViewById(R.id.btn_clientmap) ;
        routName = findViewById(R.id.tv_routName);

        Intent i  = getIntent() ;
        getRoutName = i.getStringExtra("Rout");
        routName.setText(getRoutName);

        new AccessDatabase().execute();
    }
    public class AccessDatabase extends AsyncTask<String,String,String>{


        protected void onPreExecute() {

        }


        protected void onPostExecute(String s) {
            try {
                JSONObject jsonResult = new JSONObject(s);
                int success = jsonResult.getInt("success");
                if(success == 1){

                    JSONArray location = jsonResult.getJSONArray("location");

                    for(int i=0;i<location.length();i++){
                        JSONObject loc = location.getJSONObject(i);
                        String drivername = loc.getString("driver_email-id");
                        final String latti = loc.getString("latitude");
                        final String longi = loc.getString("longitude");



                        ClientActivity.driverName.setText(drivername);
                        ClientActivity.latitude.setText(latti);
                        ClientActivity.longitude.setText(longi);

                        map.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String mapUrl = "http://map.google.com/maps?q=loc:";
                                String url = mapUrl + latti +","+ longi;
                                Toast.makeText(getApplicationContext(), url,Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                        });

                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Database has no Location Record",Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }


        }


        protected String doInBackground(String... param) {
            String result = "";





            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(url));
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer stringBuffer = new StringBuffer("");

                String line = "";
                while((line = reader.readLine()) != null){
                    stringBuffer.append(line);
                    break;
                }
                reader.close();
                result = stringBuffer.toString();



            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return result;
        }


    }


}
