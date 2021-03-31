package com.example.votersystem.data.model;

public class usermodel {
    private String fullname;
    private int phone;
    public int vote_check;

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public int getVote_check() {
        return vote_check;
    }
    public void setVote_check(int vote_check) {
        this.vote_check = vote_check;
    }
}
