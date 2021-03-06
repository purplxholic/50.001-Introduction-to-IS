package com.example.zan.passwordinput2;

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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(  new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText n = (EditText) findViewById(R.id.editText);
                String nw = n.getText().toString();
                System.out.println("now");
//                Toast.makeText(getApplicationContext(),"Correct Password",Toast.LENGTH_LONG).show();
                if (nw.equals("hello")){
                    Toast.makeText(getApplicationContext(),"Correct Password",Toast.LENGTH_LONG).show();
//                    Snackbar.make(view,"Correct Password", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong Password",Toast.LENGTH_LONG).show();
//                    Snackbar.make(view,"Wrong Password", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }


            }
        });

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
}
