package com.example.suryasolanki.dogbazaar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by surya.solanki on 6/30/2016.
 */
public class JSONParser {
    public static String[] animalName;
    public static int[] animalPrice;
    public static int[] animalImage;
    public static String[] priceTry;
    public static String[] tryAnimalImage;

    public Bitmap[] imagebitmap;

    public static String JSON_ARRAY="dogs";
    public static String KEY_NAME="dog_name";
    public static String KEY_IMAGE="dog_image";
    public static String KEY_PRICE="dog_price";
    public static String TRY_KEY_IMAGE="dog_image";


    private JSONArray users=null;

    private String json;

    public JSONParser(String json){
        this.json=json;
    }

   protected void parseJSON(){
       JSONObject jsonObject=null;

       try{
           jsonObject=new JSONObject(json);
           users=jsonObject.getJSONArray(JSON_ARRAY);

           animalName=new String[users.length()];
           animalPrice=new int[users.length()];
           priceTry=new String[users.length()];
           tryAnimalImage=new String[users.length()];
         //  animalImage=new int[users.length()];

           for(int i=0; i<users.length();i++){
               JSONObject jo=users.getJSONObject(i);
               animalName[i]=jo.getString(KEY_NAME);
               tryAnimalImage[i]=jo.getString(TRY_KEY_IMAGE);
               imagebitmap[i]=convertToImage(tryAnimalImage[i]);
               //animalPrice[i]=R.mipmap.arrow;
               animalPrice[i]=jo.getInt(KEY_PRICE);
               priceTry[i] =jo.getString(KEY_PRICE);


           }


       }catch (Exception ex){
           ex.printStackTrace();
       }

       }

    public Bitmap convertToImage(String image){
        try {
        InputStream inputStream=new ByteArrayInputStream(image.getBytes());
        Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
        Log.v("JSONPARSER","Image converted");
        return bitmap;
        }catch (Exception ex){
            return null;
        }
    }



}
