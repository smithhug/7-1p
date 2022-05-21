package com.example.a7_1p;

import android.app.RemoteAction;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String DESC = "description";
    public static final String DATE = "date";
    public static final String LOC = "loc";
    public static final String PHONE = "phone";
    public static final String TABLE_NAME = "items_list";


    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LFItems_db";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, " + DESC + " TEXT, " + DATE + " TEXT, " + LOC + " TEXT, " + PHONE + " TEXT)";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// This database is only a cache for online data, so its upgrade policy is
// to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long insert(String name, String description, String date, String phone, String location)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(DESC, description);
        contentValues.put(DATE, date);
        contentValues.put(PHONE, phone);
        contentValues.put(LOC, location);
        long newRowId = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    public Cursor fetch() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.NAME, DatabaseHelper.DATE, DatabaseHelper.LOC };
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetchTitle(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.NAME, DatabaseHelper.DATE, DatabaseHelper.LOC };
        String selection = NAME + " = ?";
        String[] selectionArgs = { title };
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean removeItem(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = NAME + " = ?";
        String[] selectionArgs = { title };
        int deletedRows = db.delete(TABLE_NAME, selection, selectionArgs);
        if (deletedRows > 0)
            return true;
        else
            return false;
    }
}