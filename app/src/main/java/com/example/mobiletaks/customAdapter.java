package com.example.mobiletaks;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class customAdapter extends BaseAdapter {
    String [] result;
    Context context;
    TypedArray imageId;
    String [] lele;
    private static LayoutInflater inflater = null;

    public customAdapter(AppCompatActivity appCompatActivity, String[] osNameList, TypedArray osImages){
        result=osNameList;
        context=appCompatActivity;
        imageId=osImages;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount(){
        return result.length;
    }

    public Object getItem(int position){
        return position;
    }

    public long getItemId(int position){
        return position;
    }

    public class Holder{
        TextView os_text;
        ImageView os_img;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_layout, null);
        holder.os_text = (TextView) rowView.findViewById(R.id.os_texts);
        holder.os_img = (ImageView) rowView.findViewById(R.id.os_images);

        holder.os_text.setText(result[position]);
        holder.os_img.setImageResource(imageId.getResourceId(position,-1));


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context.getApplicationContext(),fuu_item.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(i);

            }
        });
        return rowView;
    }
}
