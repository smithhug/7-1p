package com.example.a7_1p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class showads extends AppCompatActivity {

    public DatabaseHelper db;
    public Cursor cursor;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showads);
        db = new DatabaseHelper(this);
        cursor = db.fetch();
        cursor.moveToFirst();
        listView = findViewById(R.id.listView);
        ItemAdaptor itemAdaptor = new ItemAdaptor(this, cursor);
        listView.setAdapter(itemAdaptor);
        itemAdaptor.changeCursor(cursor);
    }

    public void onClickItem(View view){
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        Intent newintent = new Intent(showads.this, oneitem.class);
        newintent.putExtra("buttonText", buttonText);
        startActivity(newintent);
    }
}