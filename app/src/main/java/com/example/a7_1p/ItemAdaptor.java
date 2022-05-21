package com.example.a7_1p;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ItemAdaptor extends CursorAdapter {
    public ItemAdaptor(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvButton = (TextView) view.findViewById(R.id.tvButton);
        TextView tvID = (TextView) view.findViewById(R.id.tvPriority);
        String body = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        int ID = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        tvButton.setText(body);
        tvID.setText(String.valueOf(ID));
    }
}