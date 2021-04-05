package com.example.votersystem.data.model;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.votersystem.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class votemodel {

    private String topicOne;
    private String topicTwo;

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

    public String getTopicOne() {
        return topicOne;
    }

    public void setTopicOne(String topicOne) {
        this.topicOne = topicOne;
    }

    public String getTopicTwo() {
        return topicTwo;
    }

    public void setTopicTwo(String topicTwo) {
        this.topicTwo = topicTwo;
    }

    public int getCountOne() {
        return countOne;
    }

    public void setCountOne(int countOne) {
        this.countOne = countOne;
    }

    public int getCountTwo() {
        return countTwo;
    }

    public void setCountTwo(int countTwo) {
        this.countTwo = countTwo;
    }
}
