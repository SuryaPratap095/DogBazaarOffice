package com.example.suryasolanki.dogbazaar;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class AnimalServiceList extends AppCompatActivity {

    private ProgressDialog pDialog;
    Context context;
    public static final String JSONURL="http://172.16.21.77/dogbazaar/get_all_dogs.php";

    ListView listView;
    int imageNext=R.mipmap.arrow;
    //JSONParser jsonParser=new JSONParser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_service_list);
        listView=(ListView)findViewById(R.id.serviceList);
       // listView.setAdapter();
      //  CustomServiceListView customServiceListView=new CustomServiceListView(this,)

        sendRequest();
    }
    private void sendRequest(){
        StringRequest stringRequest=new StringRequest(JSONURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AnimalServiceList.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String JSON){
        JSONParser jsonParser=new JSONParser(JSON);
        jsonParser.parseJSON();

        CustomServiceListView customServiceListView=new CustomServiceListView(this,imageNext,jsonParser.animalName,
                jsonParser.animalPrice,imageNext);
        listView.setAdapter(customServiceListView);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animal_service_list, menu);
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
