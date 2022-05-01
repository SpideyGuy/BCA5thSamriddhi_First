package com.bca.firstproject;

import android.graphics.drawable.Drawable;

public class StudentRecord {

    String title;
    String date;
    String description;

    String nickname;
    String phone;
    String photo;

    public StudentRecord(){
    };

    public StudentRecord(String title, String date, String description){
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public StudentRecord(String name,
                         String nickname,
                         String phone,
                         String photo){
        this.title = name;
        this.nickname = nickname;
        this.phone = phone;
        this.photo = photo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
