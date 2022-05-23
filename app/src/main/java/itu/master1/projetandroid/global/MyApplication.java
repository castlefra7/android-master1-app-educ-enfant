package itu.master1.projetandroid.global;

import android.app.Application;

public class MyApplication extends Application {
    //public static String URL = "http://192.168.88.20:3000/";
    public static String URL = "https://projetandroid.herokuapp.com/";
    public static String IMAGE_URL = "https://projetandroid.herokuapp.com/images/";
    private String token;
    public String name;
    public String email;
    public int role;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
