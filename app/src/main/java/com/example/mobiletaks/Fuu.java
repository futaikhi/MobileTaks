package com.example.mobiletaks;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class Fuu extends AppCompatActivity {

    GridView gridView;

    String [] osNameList;

    TypedArray osImages;

    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuu);
        osNameList = getResources().getStringArray(R.array.tesArray);
        osImages = getResources().obtainTypedArray(R.array.gambar);
        gridView = (GridView)findViewById(R.id.customgrid);
        gridView.setAdapter(new CustomAdapter(this, osNameList, osImages));

        btn = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fuu.this,MainActivity.class);
                Fuu.this.startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed(){
        finishAffinity();
    }

}