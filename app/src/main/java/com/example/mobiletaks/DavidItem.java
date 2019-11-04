package com.example.mobiletaks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import topsis.Topsis;

public class DavidItem extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vii_list);

        SharedPreferences mPrefanfences;
        mPrefanfences = PreferenceManager.getDefaultSharedPreferences(this);

        String[] namagame;
        int[] agame;
        int[] bgame;
        int[] cgame;
        int[] wgame;
        String[] gambargame;

        String npm = mPrefanfences.getString("com.example.mobiletaks.npm","");
        String nana = mPrefanfences.getString("com.example.mobiletaks.nama","");

        TextView tek = (TextView)findViewById(R.id.textView2);
        tek.setText(npm);
        TextView la = (TextView)findViewById(R.id.textView6);
        la.setText(nana);

        ArrayList<SubjetData> data = new ArrayList<SubjetData>();
        namagame = getResources().getStringArray(R.array.game);
        agame = getResources().getIntArray(R.array.tampilan);
        bgame = getResources().getIntArray(R.array.minimum);
        cgame = getResources().getIntArray(R.array.comunity);
        wgame = getResources().getIntArray(R.array.wgame);
        gambargame = getResources().getStringArray(R.array.gambarGame);
        Topsis topsis = new Topsis(agame,bgame,cgame,namagame,wgame,gambargame);
        final ListView daftar = findViewById(R.id.listvii);
        for (int i = 0 ; i < namagame.length ; i++){
            data.add(new SubjetData(topsis.cetak()[i].getNama(),topsis.cetak()[i].getNilai(),topsis.cetak()[i].getGambar()));
        }
        CustomAdapterList customadapterlist = new CustomAdapterList(this,data);
        daftar.setAdapter(customadapterlist);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(DavidItem.this,David.class);
        DavidItem.this.startActivity(intent);
        finish();
    }
}
