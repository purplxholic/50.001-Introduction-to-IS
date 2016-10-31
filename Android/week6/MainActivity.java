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

public class MainActivity extends AppCompatActivity {
    private Cursor c;
    private static final String SELECT_SQL = "SELECT * FROM student";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button logn = (Button) findViewById(R.id.button3);




    }
    public void login(View v){
        EditText password = (EditText) findViewById(R.id.editText4);
        if (password.getText().toString().equals("1")){
            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
        }
}


}


