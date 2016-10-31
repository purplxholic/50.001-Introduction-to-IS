package com.example.zan.firebaseextended;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseDatabase database; // to send to database


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml
        final ListView listView = (ListView) findViewById(R.id.listView);

        // Create a new Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // Connect to the Firebase database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();


        // Add items via the Button and EditText at the bottom of the window.
        final EditText pillarinput = (EditText) findViewById(R.id.todoText);
        final Button button = (Button) findViewById(R.id.addButton);
        final EditText nameinput = (EditText) findViewById(R.id.editText);
        final Button searchbutton = (Button) findViewById(R.id.button);

        // Get a reference to the todoItems child items it the database
        final DatabaseReference myRef = database.getReference("Person");

        // Assign a listener to detect changes to the child items
        // of the database reference.
        myRef.addChildEventListener(new ChildEventListener() {

            // This function is called once for each child that exists
            // when the listener is added. Then it is called
            // each time a new child is added.
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                String value = (String) dataSnapshot.getKey();
                adapter.add(value);
            }

            // This function is called each time a child item is removed.
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                adapter.remove(value);
            }

            // The following functions are also required in ChildEventListener implementations.
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG:", "Failed to read value.", error.toException());
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String value1 = nameinput.getText().toString();
                String value2 = pillarinput.getText().toString();
                DatabaseReference nRefChild = myRef.child(value1);
                DatabaseReference nRefChild2 = nRefChild.child("name");
                DatabaseReference nRefChild3 = nRefChild.child("pillar");
                nRefChild2.setValue(value1);
                nRefChild3.setValue(value2);

            }
        });

        searchbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DatabaseReference child = myRef.child(nameinput.getText().toString());
                String displayname =  nameinput.getText().toString();
                TextView namedisplay = (TextView) findViewById(R.id.textView4);
                namedisplay.setText(displayname);
                child.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        HashMap<String,String> hello = (HashMap) dataSnapshot.getValue();
                        String pillar = hello.get("pillar");
                        TextView pillardisplay = (TextView) findViewById(R.id.Name);
                        pillardisplay.setText(pillar);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        // Delete items when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Query myQuery = myRef.orderByValue().equalTo((String)
                        listView.getItemAtPosition(position));

                myQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()) {
                            DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                            firstChild.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                })
                ;
            }
        })
        ;
    }
}

