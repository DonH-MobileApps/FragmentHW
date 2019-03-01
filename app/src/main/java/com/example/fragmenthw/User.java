package com.example.fragmenthw;

public class User {

    private String userName;
    private String userEmail;
    private String UserPassword;


    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        UserPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }



    public String getUserEmail() {
        return userEmail;
    }


    public String getUserPassword() {
        return UserPassword;
    }


}

