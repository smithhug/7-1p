package com.example.a7_1p;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicknew(View view)
    {
        Intent newintent = new Intent(MainActivity.this, newad.class);
        startActivity(newintent);
    }

    public void onClickview(View view)
    {
        Intent newintent = new Intent(MainActivity.this, showads.class);
        startActivity(newintent);
    }
}