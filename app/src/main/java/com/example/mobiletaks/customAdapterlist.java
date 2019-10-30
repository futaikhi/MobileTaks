package com.example.mobiletaks;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class customAdapterlist implements ListAdapter {

    ArrayList<subjectData> arrayList;
    Context context;

    public customAdapterlist(Context context,ArrayList<subjectData> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }

    public void registerDataSetObserver(DataSetObserver observer)
    {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }


    @Override
    public View getView( int position, View convertView, ViewGroup parent)
    {
        subjectData subjectdata = arrayList.get(position);
        if (convertView==null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.customlist,null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            TextView title = convertView.findViewById(R.id.title);
            TextView subtitle = convertView.findViewById(R.id.subtitle);
            ImageView imageView = convertView.findViewById(R.id.icon);
            title.setText(subjectdata.SubjectName);
            subtitle.setText(String.valueOf(subjectdata.nilai));
            Picasso.with(context).load(subjectdata.gambar).into(imageView);
    }
        return convertView;
    }

    public int getItemViewType(int position)
    {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
}
