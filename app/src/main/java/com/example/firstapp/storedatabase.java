package com.example.firstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class storedatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "lessonDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";

    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_EMAIL= "user_email";
    public static final String COLUMN_USER_PASSWORD = "user_password";
    public static final String COLUMN_USER_PHONE = "user_phone";

    Context context;

    public storedatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public storedatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_USER_NAME + " TEXT, " +
                COLUMN_USER_EMAIL + " TEXT , " +
                COLUMN_USER_PASSWORD + " TEXT , " +
                COLUMN_USER_PHONE + " INTIGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        onCreate(db);
    }
}