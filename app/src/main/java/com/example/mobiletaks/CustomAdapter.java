package com.example.mobiletaks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class CustomAdapter extends BaseAdapter {
    String [] result;
    Context context;
    TypedArray imageId;
    String [] lele;
    private static LayoutInflater inflater = null;

    public CustomAdapter(AppCompatActivity appCompatActivity, String[] osNameList, TypedArray osImages){
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
        ProgressBar progressBar;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        final Holder holder = new Holder();
        final View rowView;

        rowView = inflater.inflate(R.layout.grid_layout, null);
        holder.os_text = (TextView) rowView.findViewById(R.id.os_texts);
        holder.os_img = (ImageView) rowView.findViewById(R.id.os_images);

        holder.os_text.setText(result[position]);
        holder.os_img.setImageResource(imageId.getResourceId(position,-1));


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result[position].equals("Smartphone")) {
                    Intent i = new Intent(context.getApplicationContext(), FuuItem.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    holder.progressBar = (ProgressBar)rowView.findViewById(R.id.loading);
                    holder.progressBar.setVisibility(view.VISIBLE);
                    context.getApplicationContext().startActivity(i);
                }
                else if (result[position].equals("Battle Royal"))
                {
                    Intent i = new Intent(context.getApplicationContext(), DavidItem.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    holder.progressBar = (ProgressBar)rowView.findViewById(R.id.loading);
                    holder.progressBar.setVisibility(view.VISIBLE);
                    context.getApplicationContext().startActivity(i);
                }
                else if (result[position].equals("Headphone")){
                    Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                }
                else if (result[position].equals("Memory Card")){
                    Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                }
                else if (result[position].equals("FPS")){
                    Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                }
                else if (result[position].equals("MMORPG")){
                    Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                }
                else if (result[position].equals("Simulation")){
                    Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                }
                else if (result[position].equals("Strategy")){
                    Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                }
                else if (result[position].equals("Visual Novel")){
                    Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                }
                else{
//                    Toast.makeText(context, "Kamu menekan "+result[position], Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                    builder.setMessage("Anda Perlu Login untuk dapat membuka "+result[position]).setNegativeButton("Ok",null).create().show();
                }

            }
        });
        return rowView;
    }
}
