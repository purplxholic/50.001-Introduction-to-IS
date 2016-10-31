package com.example.zan.sqlpart1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private Cursor c;
    private static final String SELECT_SQL = "SELECT * FROM student";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = (Button) findViewById(R.id.button);
        Button display = (Button) findViewById(R.id.button2);
        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText address = (EditText) findViewById(R.id.editText2);
        final EditText phone = (EditText) findViewById(R.id.editText3);
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getApplicationContext());

        final SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final ContentValues values = new ContentValues();
        c = db.rawQuery(SELECT_SQL, null);
        c.moveToFirst();

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                values.put(FeederReaderContract.FeedEntry.COLUMN_NAME_NAME,name.getText().toString());
                values.put(FeederReaderContract.FeedEntry.COLUMN_NAME_ADD,address.getText().toString());
                values.put(FeederReaderContract.FeedEntry.COLUMN_NAME_PHONE,phone.getText().toString());
                long newRowId = db.insert(FeederReaderContract.FeedEntry.TABLE_NAME,null,values);
            }
        });

        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                c = db.rawQuery(SELECT_SQL, null);
                c.moveToFirst();
                while (c.isAfterLast()==false) {
                    TextView namedisokay = (TextView) findViewById(R.id.namedisplay);
                    TextView addisplay = (TextView) findViewById(R.id.addressdisplay);
                    TextView phone = (TextView) findViewById(R.id.phonedisplay);
//                    namedisokay.setText(c.getString(0));
                    namedisokay.setText(c.getString(c.getColumnIndex("name")));


                    addisplay.setText(c.getString(c.getColumnIndex("address")));
                    phone.setText(c.getString(c.getColumnIndex("phone")));
                    c.moveToNext();


                }
            }
        });
    }

    public boolean deleteTable(View v){
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getApplicationContext());
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.execSQL("delete from student");
        return true;
    }
}

class FeedReaderDbHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeederReaderContract.FeedEntry.TABLE_NAME + " (" +
                    FeederReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeederReaderContract.FeedEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    FeederReaderContract.FeedEntry.COLUMN_NAME_ADD + TEXT_TYPE + COMMA_SEP +
                    FeederReaderContract.FeedEntry.COLUMN_NAME_PHONE + TEXT_TYPE +" )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeederReaderContract.FeedEntry.TABLE_NAME;
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
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
}

final class FeederReaderContract{

    private FeederReaderContract(){}

    public static class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME_NAME ="name";
        public static final String COLUMN_NAME_ADD = "address";
        public static final String COLUMN_NAME_PHONE = "phone";
    }
}
