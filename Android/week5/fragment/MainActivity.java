package com.example.zan.fragment;

//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button first = (Button) findViewById(R.id.button1)  ;
//        first.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                ImageView yo = (ImageView) findViewById(R.id.imageView);
//                yo.setImageResource(R.drawable.swan8);
//            }
//        });
//
//        Button second = (Button) findViewById(R.id.button2);
//        second.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                ImageView yo = (ImageView) findViewById(R.id.imageView);
//                yo.setImageResource(R.drawable.swan8);
//            }
//        });
//
//        Button third = (Button) findViewById(R.id.button3);
//        third.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                ImageView yo = (ImageView) findViewById(R.id.imageView);
//                yo.setImageResource(R.drawable.swan8);
//            }
//        });
    }
    public void selectFrag(View view){
        android.app.Fragment fr;
        if (view == findViewById(R.id.button2)){
            Toast.makeText(getApplicationContext(),"Going to SUTD website",Toast.LENGTH_LONG).show();
            fr = new Fragment2();
        }else{
            fr = new BlankFragment();
//            ImageView yo = (ImageView) findViewById(R.id.imageView);
//                yo.setImageResource(R.mipmap.ic_launcher);
        }
        if(view ==findViewById(R.id.button3)){
            fr = new Fragment_three();
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place,fr);
        fragmentTransaction.commit();
    }
}

//http://www.techotopia.com/index.php/Using_Fragments_in_Android_-_A_Worked_Example
//http://stackoverflow.com/questions/18711433/button-listener-for-button-in-fragment-in-android