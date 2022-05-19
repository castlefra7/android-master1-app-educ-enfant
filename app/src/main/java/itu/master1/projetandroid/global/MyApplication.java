package itu.master1.projetandroid.global;

import android.app.Application;

public class MyApplication extends Application {
    private String token;
    private boolean aOuvertCeJour;

    public boolean isaOuvertCeJour() {
        return aOuvertCeJour;
    }

    public void setaOuvertCeJour(boolean aOuvertCeJour) {
        this.aOuvertCeJour = aOuvertCeJour;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
