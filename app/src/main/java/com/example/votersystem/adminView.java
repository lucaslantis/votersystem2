package com.example.votersystem;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminView extends AppCompatActivity {

    private DatabaseReference votemodel;
    private DatabaseReference usermodel;
    private TextView mquestionview;
    private RadioButton moption1;
    private RadioButton moption2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quesview);

        mdatabase = FirebaseDatabase.getInstance().getReference().child("Question");
        mdatabase1 = FirebaseDatabase.getInstance().getReference().child("Option1");
        mdatabase2 = FirebaseDatabase.getInstance().getReference().child("Option2");
        mquestionview = (TextView) findViewById(R.id.question);
        moption1 = (Button) findViewById(R.id.);
        moption2 = (Button) findViewById(R.id.);

        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue().toString();
                mquestionview.setText(question);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mdatabase1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String option1 = dataSnapshot.getValue().toString();
                moption1.setText(option1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mdatabase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String option2 = dataSnapshot.getValue().toString();
                moption2.setText(option2);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    public void back(View view){
        Intent backopen = new Intent(this,question.class);
        startActivity(backopen);
    }
}
