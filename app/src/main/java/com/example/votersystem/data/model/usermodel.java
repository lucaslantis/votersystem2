package com.example.votersystem.data.model;

public class    usermodel {
    private String emailm;
    private String fullname;
    private String phone;
    public int vote_check;
    private int type;

    public usermodel() {
    }

    public usermodel(String emailm, String fullname, String phone, int vote_check, int type) {
        this.emailm = emailm;
        this.fullname = fullname;
        this.phone = phone;
        this.vote_check = vote_check;
        this.type = type;
    }

    public String getEmailm() {
        return emailm;
    }
    public void setEmailm(String emailm) {
        this.emailm = emailm;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getVote_check() {
        return vote_check;
    }
    public void setVote_check(int vote_check) {
        this.vote_check = vote_check;
    }
}
