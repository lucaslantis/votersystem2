package com.example.votersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class votepage extends AppCompatActivity {
Button candidate1;
Button candidate2;
TextView voteCount1;
TextView voteCount2;
int votecheck;
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votepage);
        candidate1 = findViewById(R.id.btnoption1);
        candidate2 = findViewById(R.id.btnoption2);
        voteCount1 = findViewById(R.id.option1count);
        voteCount2 = findViewById(R.id.option2count);

        mFirebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        if(votecheck = 1) {

        }
            candidate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    votecheck = 1;

                }

    }

    }
}