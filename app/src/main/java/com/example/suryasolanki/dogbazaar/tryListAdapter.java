package com.example.suryasolanki.dogbazaar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by surya.solanki on 7/26/2016.
 */
public class tryListAdapter extends BaseAdapter {

    private Context mContext;
    private String[] animalName;
    private String[] animaPrice;
    private static LayoutInflater inflater;
    public tryListAdapter(Context mcontext,String[] animalName,String[] animalPrice){
        this.animalName=animalName;
        this.mContext=mcontext;
        this.animaPrice=animalPrice;
        inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return animalName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View rowView=inflater.inflate(R.layout.try_list_view,null);

        TextView tryTxtAnimalName=(TextView)rowView.findViewById(R.id.tryAnimalName);
        TextView tryTxtAnimalPrice=(TextView)rowView.findViewById(R.id.tryAnimalPrice);

        tryTxtAnimalName.setText(animalName[position]);
        tryTxtAnimalPrice.setText(animaPrice[position]);


        return rowView;
    }
}
