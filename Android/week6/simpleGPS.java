package com.example.zan.gettinglocation;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void map(View view){
        EditText location = (EditText) findViewById(R.id.editText);
        String locationname = location.getText().toString();

        List<Address> addressList = null;
        try{
            Geocoder test = new Geocoder(this);
            addressList = test.getFromLocationName(locationname,1);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (IllegalArgumentException e){
            Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
        }

        String lat = null;
        String lon = null;

        try{
            lat = String.valueOf(addressList.get(0).getLatitude());
            lon = String.valueOf(addressList.get(0).getLongitude());
        }
        catch (NullPointerException e){
            Toast.makeText(getApplicationContext(),"No input",Toast.LENGTH_LONG).show();
        }

            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("geo:0,0?q=" + locationname));
        intent.setData(Uri.parse("geo:"+lat+","+lon));
            startActivity(Intent.createChooser(intent, "Launch Maps"));

    }

}
