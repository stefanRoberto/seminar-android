package com.example.seminarandroid;

import java.io.Serializable;

public class Profil implements Serializable {
    private String email;
    private String nume;
    private int varsta;

    public Profil(String email) {
        this.email = email;
    }

    public Profil(String email, String nume, int varsta) {
        this.email = email;
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

}
