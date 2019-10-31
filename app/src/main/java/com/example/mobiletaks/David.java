package com.example.mobiletaks;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class David extends AppCompatActivity {
    Button btn;

    GridView gridView;
    String [] osNameList;

    TypedArray osImages;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.vii);

        osNameList = getResources().getStringArray(R.array.gamestore);
        osImages = getResources().obtainTypedArray(R.array.gameimg);
        gridView = (GridView)findViewById(R.id.customgrid1);
        gridView.setAdapter(new CustomAdapter(this, osNameList, osImages));

        btn = (Button)findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(David.this,MainActivity.class);
                David.this.startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed(){
        finishAffinity();
    }
}
