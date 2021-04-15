package com.example.votersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class admin extends AppCompatActivity {
    TextView viewQuestion;
    TextView viewOne;
    TextView viewTwo;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


            setContentView(R.layout.activity_admin);
            viewQuestion = (TextView) findViewById(R.id.pollQuestion);
            viewOne = (TextView) findViewById(R.id.option1);
            viewTwo = (TextView) findViewById(R.id.option2);
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference();
        }
        public void submitButton (View view){
            databaseReference.child("Question").setValue(viewQuestion.getText().toString());
            databaseReference.child("Option1").setValue(viewOne.getText().toString());
            databaseReference.child("Option2").setValue(viewTwo.getText().toString());
        }
        public void getResult (View view){
            Intent startview = new Intent(this, adminView.class);
            startActivity(startview);
        }
    }
    }
}
