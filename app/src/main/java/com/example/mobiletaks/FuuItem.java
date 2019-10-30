package com.example.mobiletaks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import topsis.Topsis;

public class FuuItem extends AppCompatActivity {
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.list_item);
        String[] nama;
        int[] a;
        int[] b;
        int[] c;
        int[] w;
        String[] gambar;
        ArrayList<SubjetData> data = new ArrayList<SubjetData>();
        nama = getResources().getStringArray(R.array.hp);
        a = getResources().getIntArray(R.array.baterai);
        b = getResources().getIntArray(R.array.panelLayar);
        c = getResources().getIntArray(R.array.design);
        w = getResources().getIntArray(R.array.w);
        gambar = getResources().getStringArray(R.array.gambarProduk);
        Topsis topsis = new Topsis(a,b,c,nama,w,gambar);
        final ListView daftar = findViewById(R.id.list);
        for (int i = 0 ; i < nama.length ; i++){
            data.add(new SubjetData(topsis.cetak()[i].getNama(),topsis.cetak()[i].getNilai(),topsis.cetak()[i].getGambar()));
        }
        CustomAdapterList customadapterlist = new CustomAdapterList(this,data);
        daftar.setAdapter(customadapterlist);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(FuuItem.this,Fuu.class);
        FuuItem.this.startActivity(intent);
        finish();
    }
}
