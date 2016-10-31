package com.example.zan.checkoff3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    this is the code to create a second activity. intent is the bridge between
    the two activities. to create a linked acitvity, new > new activity>
    basic activity
     */
    public void sendmessage(View view){
        Button b = (Button) findViewById(R.id.button);
        if (b.getText().equals("Test 3")){
            b.setText("Hi");
        } else if (b.getText().equals("Hi")){
            b.setText("Test 3");
        }
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        // this refers to the current class. the other class is to link to the new activity
        //class name
        startActivity(intent);
    }

    public void sendemail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "zanette_cheng@mymail.sutd.edu.sg" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        intent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        startActivity(Intent.createChooser(intent, ""));
    }
}
