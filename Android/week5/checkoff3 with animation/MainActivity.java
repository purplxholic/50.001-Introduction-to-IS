package com.example.zan.checkoff3;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);

        //rotate left and right
        image.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate));

        //left and right
        image2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate));

        //scale

        ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        image3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale));
//Has fixed duration

//                RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                rotate.setDuration(1000);
//                rotate.setInterpolator(new LinearInterpolator());
//                image.startAnimation(rotate);
//                    RotateAnimation rrotate = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                    rrotate.setDuration(1000);
//                    rrotate.setInterpolator(new LinearInterpolator());
//                    image.startAnimation(rrotate);

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
