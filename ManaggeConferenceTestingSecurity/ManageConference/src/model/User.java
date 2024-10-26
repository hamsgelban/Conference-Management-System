package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import security.Hashing;

public class User {

    private String username;
    private String passwordHash; // Store the hashed password instead of plain text
    private String fname;
    private String lname;
    private boolean isLogged = false;

    public User(String username, String password, String fname, String lname) {
        this.username = username;
        this.passwordHash = Hashing.hashPassword(password);
        this.fname = fname;
        this.lname = lname;
    }


    public String getUsername() {
        return username;
    }

    public void setIsLogged(boolean b) {
        isLogged = b;
    }

    public boolean login(String user, String pass) {
        // Compare the provided password with the hashed password
        return username.equals(user) && passwordHash.equals(Hashing.hashPassword(pass));
    }

    public boolean isLogged() {
        return isLogged;
    }

    public boolean isValid(String username, String password) {
        return this.username.equalsIgnoreCase(username) && passwordHash.equals(Hashing.hashPassword(password));
    }
}
