package com.example.votersystem.data.model;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.votersystem.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class votemodel extends AppCompatActivity {
    /** Link to the root node in the DB */
    FirebaseDatabase database;
    int initialID = 0;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
    }

    private String topicOne;
    private String topicTwo;
    private String adminName;
    private String adminPass;
    public int countOne;
    public int countTwo;

    public votemodel(String topicOne, String topicTwo)
    {
        this.topicOne = topicOne;
        this.topicTwo = topicTwo;

    }
    public String showCount(int countOne, int countTwo) {
        return "topicOne" + countOne + "topicTwo" + countTwo;
    }
    public String getTopicOne(){
        return topicOne;
    }
    public String getTopicTwo(){
        return topicTwo;
    }
    public void setTopicOne(String topicOne){
        this.topicOne = topicOne;
    }
    public void setTopicTwo(String topicTwo){
        this.topicTwo = topicTwo;
    }
}
