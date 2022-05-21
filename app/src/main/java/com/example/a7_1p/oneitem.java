package com.example.a7_1p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class oneitem extends AppCompatActivity {

    String title;
    String date;
    String loc;
    public DatabaseHelper db;
    public Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneitem);
        Intent intent = getIntent();
        title = intent.getStringExtra("buttonText");
        TextView titleText = findViewById(R.id.textViewItemname);
        titleText.setText(title);

        db = new DatabaseHelper(this);
        cursor = db.fetchTitle(title);
        cursor.moveToFirst();
        date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
        loc = cursor.getString(cursor.getColumnIndexOrThrow("loc"));

        TextView dateText = findViewById(R.id.textViewItemdate);
        TextView locText = findViewById(R.id.textViewItemlocation);

        dateText.setText(date);
        locText.setText(loc);

    }

    public void onClickDelete(View view) {
        if (db.removeItem(title)) {
            Toast.makeText(getApplicationContext(), "Removed from database", Toast.LENGTH_SHORT).show();
            Intent newintent = new Intent(oneitem.this, showads.class);
            startActivity(newintent);
        }
    }
}