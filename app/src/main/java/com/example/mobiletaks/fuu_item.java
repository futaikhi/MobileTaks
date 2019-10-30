package com.example.mobiletaks;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import topsis.Topsis;
import topsis.Data;

public class fuu_item extends AppCompatActivity {
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
//        String[] nama = { "Samsung", "Xiaomi", "Iphone", "Oppo" };
//        int[] a = { 3, 5, 2, 3 };
//        int[] b = { 5, 2, 4, 1 };
//        int[] c = { 3, 2, 5, 2 };
//        int[] w = { 2, 4, 5 };
//        int[] gambar = { 4, 1, 23, 2, 3 };
        ArrayList<subjectData> data = new ArrayList<subjectData>();
        nama = getResources().getStringArray(R.array.hp);
        a = getResources().getIntArray(R.array.baterai);
        b = getResources().getIntArray(R.array.panelLayar);
        c = getResources().getIntArray(R.array.design);
        w = getResources().getIntArray(R.array.w);
        gambar = getResources().getStringArray(R.array.gambarProduk);
        Topsis topsis = new Topsis(a,b,c,nama,w,gambar);
        final ListView daftar = findViewById(R.id.list);
        for (int i = 0 ; i < nama.length ; i++){
            data.add(new subjectData(topsis.cetak()[i].getNama(),topsis.cetak()[i].getNilai(),topsis.cetak()[i].getGambar()));
        }
        customAdapterlist customadapterlist = new customAdapterlist(this,data);
        daftar.setAdapter(customadapterlist);

    }
}
