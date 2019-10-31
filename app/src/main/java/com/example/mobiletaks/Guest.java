package com.example.mobiletaks;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.GridView;

public class Guest extends Fuu {
    GridView gridView,tes;

    String [] osNameList;
    String [] name;

    TypedArray img;
    TypedArray osImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest);

        osNameList = getResources().getStringArray(R.array.guestA);
        osImages = getResources().obtainTypedArray(R.array.gambar);
        gridView = (GridView)findViewById(R.id.customgrid2);
        gridView.setAdapter(new CustomAdapter(this, osNameList, osImages));

        name = getResources().getStringArray(R.array.guestB);
        img = getResources().obtainTypedArray(R.array.gameimg);
        tes = (GridView)findViewById(R.id.customgrid3);
        tes.setAdapter(new CustomAdapter(this, name, img));
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Guest.this,MainActivity.class);
        Guest.this.startActivity(intent);
        finish();
    }
}
