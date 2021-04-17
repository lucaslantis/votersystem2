package com.example.votersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.votersystem.data.model.question;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.votersystem.R.id.pollQuestion;

public class admin extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    int initialID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        }
        public void submitButton (View view){
            @SuppressLint("WrongViewCast") EditText pollQuestion = findViewById(R.id.viewQuestion);
            @SuppressLint("WrongViewCast") EditText option1 = findViewById(R.id.viewOne);
            @SuppressLint("WrongViewCast") EditText option2 = findViewById(R.id.viewTwo);
            String viewQuestion = pollQuestion.getText().toString();
            String viewOne = option1.getText().toString();
            String viewTwo = option2.getText().toString();
            question newQuestion = new question (String.valueOf(initialID), viewQuestion);
            initialID ++;
            // Login to Firebase project and get instance of the DB and point to the root
            database= FirebaseDatabase.getInstance();
            // Set reference to the Tasks table
            databaseReference = FirebaseDatabase.getReference("question");
            databaseReference.child(newQuestion.toString()).setValue(newQuestion);
        }
        public void getResult (View view){
            Intent startview = new Intent(this, adminView.class);
            startActivity(startview);
        }
    }
    }
}
