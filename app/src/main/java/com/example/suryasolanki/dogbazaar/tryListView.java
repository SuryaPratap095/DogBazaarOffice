package com.example.suryasolanki.dogbazaar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class tryListView extends AppCompatActivity {

    ListView listView;
    public static final String JSONURL="http://172.16.21.77/dogbazaar/get_all_dogs.php";
    tryListAdapter tryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_list_view);

        sendRequest();

    }

    public void sendRequest(){
        StringRequest stringRequest=new StringRequest(JSONURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(tryListView.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void showJSON(String JSONresposne){
        JSONParser jsonParser=new JSONParser(JSONresposne);
        jsonParser.parseJSON();
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,R.layout.try_array_layout,jsonParser.priceTry);
       tryListAdapter =new tryListAdapter(this,jsonParser.animalName,jsonParser.priceTry);
        listView=(ListView)findViewById(R.id.listTry);
        listView.setAdapter(new tryListAdapter(this,jsonParser.animalName,jsonParser.priceTry));
       // listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_try_list_view, menu);
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
