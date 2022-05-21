package com.example.a7_1p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class newad extends AppCompatActivity {

    public DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newad);
        db = new DatabaseHelper(this);
    }

    EditText nameV;
    EditText phV;
    EditText decV;
    EditText dateV;
    EditText locV;

    RadioButton lostbut;
    RadioButton foundbut;

    String name;
    String phone;
    String dec;
    String date;
    String location;

    public void onClicksave(View view) {
        nameV = findViewById(R.id.editTextTextPersonName);
        phV = findViewById(R.id.editTextPhone);
        decV = findViewById(R.id.editTextDesc);
        dateV = findViewById(R.id.editTextDate);
        locV = findViewById(R.id.editTextLoc);

        lostbut = findViewById(R.id.radioButtonLost);
        foundbut = findViewById(R.id.radioButtonFound);

        if (lostbut.isChecked())
            name = "Lost " + nameV.getText().toString();
        else if (foundbut.isChecked())
            name = "Found " + nameV.getText().toString();


        phone = phV.getText().toString();
        dec = decV.getText().toString();
        date = dateV.getText().toString();
        location = locV.getText().toString();

        long result = db.insert(name, dec, date, phone, location);
        if (result > 0)
        {
            Toast.makeText(getApplicationContext(),"Saved to database",Toast.LENGTH_SHORT).show();
        }

        Intent newintent = new Intent(newad.this, MainActivity.class);
        startActivity(newintent);
    }

}