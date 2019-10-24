package com.example.mobiletaks;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import java.util.Arrays;

public class fuu extends AppCompatActivity {

    GridView gridView;


    String [] osNameList;

    TypedArray osImages;

//    public  static int[] osImages = {
//            R.mipmap.anime,
//            R.mipmap.document,
//            R.mipmap.download,
//            R.mipmap.game,
//            R.mipmap.images,
//            R.mipmap.music
//    };

    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuu);
        osNameList = getResources().getStringArray(R.array.tesArray);
        osImages = getResources().obtainTypedArray(R.array.gambar);
        gridView = (GridView)findViewById(R.id.customgrid);
        gridView.setAdapter(new customAdapter(this, osNameList, osImages));

        btn = (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fuu.this,MainActivity.class);
                fuu.this.startActivity(intent);
                finish();
            }
        });
    }
}