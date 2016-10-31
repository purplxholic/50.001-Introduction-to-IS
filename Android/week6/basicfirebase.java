package com.example.zan.firebase;
//followed https://cloud.google.com/solutions/mobile/firebase-app-engine-android-studio
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseDatabase database; // to send to database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //so that the program knows which activity to go back to
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance(); // connect to firebase
        mFirebaseDatabaseReference = database.getReference("test");

        mFirebaseDatabaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG:", "Failed to read value.", databaseError.toException());
            }
        });


        final Button button = (Button) findViewById(R.id.button);
        final EditText text = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View view) {

                DatabaseReference childRed = mFirebaseDatabaseReference.push();
                childRed.setValue(text.getText().toString());
                Toast.makeText(MainActivity.this, "Conected to firebase!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

