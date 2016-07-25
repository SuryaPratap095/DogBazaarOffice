package com.example.suryasolanki.dogbazaar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by surya.solanki on 7/15/2016.
 */
public class CustomServiceListView extends BaseAdapter {

    private Context mcontext;
    private int dog_image;
    private String[] dog_name;
    private int[] dog_price;
    private int imageNext;

    public CustomServiceListView(Context mcontext, int dog_image, String[] dog_name, int[] dog_price, int imageNext) {
        this.mcontext = mcontext;
       // this.dog_image = dog_image;
        this.dog_image=dog_image;
        this.dog_name = dog_name;
        this.dog_price = dog_price;
        this.imageNext = imageNext;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater  inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View animalServiceRow=inflater.inflate(R.layout.service_custom_animal_list,null);

        TextView txtName=(TextView)animalServiceRow.findViewById(R.id.txtName);
        TextView txtPrice=(TextView)animalServiceRow.findViewById(R.id.txtPrice);
        ImageView dogImage=(ImageView)animalServiceRow.findViewById(R.id.imageNext);
        ImageView nextImage=(ImageView)animalServiceRow.findViewById(R.id.imageNext);

        txtName.setText(dog_name[position]);
        txtPrice.setText(Integer.toString(dog_price[position]));
        dogImage.setImageResource(imageNext);
        nextImage.setImageResource(imageNext);

        return animalServiceRow;
    }
}
