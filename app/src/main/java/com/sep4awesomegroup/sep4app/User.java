package com.sep4awesomegroup.sep4app;

import java.util.List;

public class User {
    private String name;
    private String email;
    private List friends;
    private String gender;
    private int age;

    private User(String name, String email, List friends, String gender,int age){
        this.name=name;
        this.email=email;
        this.friends=friends;
        this.gender=gender;
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFriends(List friends) {
        this.friends = friends;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List getFriends() {
        return friends;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
