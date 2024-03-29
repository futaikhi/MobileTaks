package com.example.mobiletaks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mPrefanfences;
    SharedPreferences.Editor mEditor;

    EditText username,pass;
    Button submit,guest;
    CheckBox centang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.editText);
        pass = (EditText)findViewById(R.id.editText2);
        submit = (Button)findViewById(R.id.button);
        centang = (CheckBox)findViewById(R.id.checkBox);
        guest = (Button)findViewById(R.id.button4);

        mPrefanfences = PreferenceManager.getDefaultSharedPreferences(this);
//        mPrefanfences = getPreferences("mydata",.MODE_PRIVATE);

        mEditor = mPrefanfences.edit();

        checkSharedPrefences();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = username.getText().toString();
                String pas = pass.getText().toString();
                if(nama.equals("fuu") && pas.equals("123"))
                {
                    if (centang.isChecked()){
                        mEditor.putString(getString(R.string.checkbox),"True");
                        mEditor.commit();

//                        String nama = username.getText().toString();
                        mEditor.putString(getString(R.string.nama), nama);
                        mEditor.commit();

//                        String passw = pass.getText().toString();
                        mEditor.putString(getString(R.string.passw), pas);
                        mEditor.commit();

                        mEditor.putString("com.example.mobiletaks.npm","06.2016.1.06663");
                        mEditor.commit();
                    }else {
                        mEditor.putString(getString(R.string.checkbox),"False");
                        mEditor.commit();

                        mEditor.putString(getString(R.string.nama), "");
                        mEditor.commit();

                        mEditor.putString(getString(R.string.passw), "");
                        mEditor.commit();

                        mEditor.putString("com.example.mobiletaks.npm","");
                        mEditor.commit();
                    }
                    Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Fuu.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }

                else if (nama.equals("lala") && pas.equals("123"))
                {
                    if (centang.isChecked()){
                        mEditor.putString(getString(R.string.checkbox),"True");
                        mEditor.commit();

//                        String nama = username.getText().toString();
                        mEditor.putString(getString(R.string.nama), nama);
                        mEditor.commit();

//                        String passw = pass.getText().toString();
                        mEditor.putString(getString(R.string.passw), pas);
                        mEditor.commit();

                        mEditor.putString("com.example.mobiletaks.npm","06.2016.1.06670");
                        mEditor.commit();
                    }else {
                        mEditor.putString(getString(R.string.checkbox),"False");
                        mEditor.commit();

                        mEditor.putString(getString(R.string.nama), "");
                        mEditor.commit();

                        mEditor.putString(getString(R.string.passw), "");
                        mEditor.commit();

                        mEditor.putString("com.example.mobiletaks.npm","");
                        mEditor.commit();
                    }
                    Toast.makeText(getApplicationContext(),"Login Succes",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, David.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }

                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username atau Password salah").setNegativeButton("Retry",null).create().show();
                }
            }
        });
    }
     public void checkSharedPrefences(){
        String checkbox = mPrefanfences.getString(getString(R.string.checkbox), "false");
        String nama = mPrefanfences.getString(getString(R.string.nama),"");
        String passw = mPrefanfences.getString(getString(R.string.passw),"");
        String npm = mPrefanfences.getString("com.example.mobiletaks.npm","");

        username.setText(nama);
        pass.setText(passw);

        if (checkbox.equals("True")){
            centang.setChecked(true);
        }else {
            centang.setChecked(false);
        }
     }

    public void click(View view) {
        Intent intent = new Intent(MainActivity.this, Guest.class);
        MainActivity.this.startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        finishAffinity();
    }

}
