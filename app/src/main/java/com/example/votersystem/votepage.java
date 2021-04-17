package com.example.votersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.votersystem.data.model.question;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.google.firebase.database.FirebaseDatabase.*;

public class votepage extends AppCompatActivity { ;
    TextView result;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votepage);
        result = (TextView) findViewById(R.id.questiontext);
        result.setEnabled(false);
        firebaseDatabase = getInstance();
        databaseReference= firebaseDatabase.getReference();
        FirebaseUser mFirebaseUser = firebaseAuth.getCurrentUser();
            databaseReference = FirebaseDatabase.getReference("question");

            // Read from the database
 databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    for (DataSnapshot taskSnapshot: dataSnapshot.getChildren()) {
                        question question = taskSnapshot.getValue(question.class);
                        Log.d("Vote", "Question is: " + question);
                        result = (TextView) result.setText().question;
                    }
                }
                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("Vote", "Failed to read question", error.toException());31
                }
    public int selectVote(View view)
    {
    int Count1 = 0;
    int Count2 = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radiob1:
                if (checked) {
                    result.setText("1:00");
                    result.setEnabled(true);
                    Count1++;
                    return Count1;
                } else {
                    result.setEnabled(false);
                }
                break;
            case R.id.radiob2:
                if (checked) {
                    result.setText("2:00");
                    result.setEnabled(true);
                    Count2++;
                    return Count2;
                } else {
                    result.setEnabled(false);
                }
        }
        return result;
    }
    }
    public void sendvote(View view){
        String n = result.getText().toString();
        if (n == "1:00") {

            databaseReference.child("1:00").push().setValue(n);
        }
        else{
            databaseReference.child("2:00").push().setValue(n);
        }
        Intent startnew = new Intent(this,MainActivity.class);
        startActivity(startnew);
    }

    }
