package ru.job4j.tracker.ex;

public class User {
    public int length;
    private String username;
    private boolean valid;

    public User(String username, boolean valid) {
        this.username = username;
        this.valid = valid;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public boolean isValid() {
        return true;
    }
}
