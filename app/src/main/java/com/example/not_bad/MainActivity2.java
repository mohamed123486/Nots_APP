package com.example.not_bad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.not_bad.fragmentfav.Favouret;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Favouret f=Favouret.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.i,f).commit();
    }
}