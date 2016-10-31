package com.example.zan.week61;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void read(View view){
try{
    FileInputStream filein = openFileInput("exampletest.txt");
    //read the file
    InputStreamReader inputread = new InputStreamReader(filein);
    //get input from the file
    StringBuilder builder = new StringBuilder();
    //can be used for reading string of unknown length
    String s = "";
    int charRead;
    char[] buffer = new char[2048]; // byte
    //fill buffer with data
    while ((charRead = inputread.read(buffer))>0){
        String readstring = String.copyValueOf(buffer,0,charRead);
        //char[] data, int offset,int count
        //will return a string representing the char seq in the array
        //specified . more in onenote on this method
        s += readstring;
    }

//    while ((s = in.readLine()) != null){
//        builder.append(s);
//    }
    inputread.close();
    Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    Toast.makeText(getBaseContext(),"File read successfully!",Toast.LENGTH_SHORT).show();

}
catch (Exception e){
    Toast.makeText(getApplicationContext(),"No file exists!", Toast.LENGTH_LONG).show();
}

    }
    public void write(View view){
        EditText n = (EditText) findViewById(R.id.editText);
        String a = n.getText().toString(); //text that will be written
        String filename = "exampletest.txt"; //file name


        try{
            FileOutputStream outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
//            OutputStreamWriter outputWriter = new OutputStreamWriter(outputStream);
//            outputWriter.write(a);
            outputStream.write(a.getBytes());
            outputStream.close();
//            outputWriter.close();
            Toast.makeText(getApplicationContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            System.out.println("Exception: file write failed!\n" + e.toString());
        }



    }
}
