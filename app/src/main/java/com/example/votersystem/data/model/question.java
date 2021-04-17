package com.example.votersystem.data.model;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.votersystem.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class question {

    public String viewOne;
    public String viewTwo;
    public String viewQuestion;
    public int voteCount1;
    public int voteCount2;
    public String fullname;
    String questionID;

    public question(String viewQuestion, String viewOne, String viewTwo, int questionID) {
        this.questionID = questionID;
        this.viewQuestion = viewQuestion;
        this.viewOne = viewOne;
        this.viewTwo = viewTwo;
    }

    public String showCount(int voteCount1, int voteCount2) {
        return "Option1" + voteCount1 + "Option2" + voteCount2;
    }

    public String getViewOne() {
        return viewOne;
    }

    public void setViewOne(String option1) {
        this.viewOne = viewOne;
    }

    public String getViewTwo()
    {
        return viewTwo;
    }

    public void setViewTwo(String topicTwo)
    {
        this.viewTwo = viewTwo;
    }


    @Override
    public String toString() {
          return "question" + questionID;
    }
}
    /* public int getvoteCount1() {
        return voteCount1;
    }

    public void setvoteCount1(int countOne)
    {
        this.voteCount1 = voteCount1;
    }

    public int getvoteCount2()
    {
        return voteCount2;
    }

    public void setVoteCount2(int countTwo)
    {
        this.voteCount2 = voteCount2;
    }
}
