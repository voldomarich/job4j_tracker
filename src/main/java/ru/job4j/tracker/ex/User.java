package ru.job4j.tracker.ex;

public class User {

    private int length;
    private final String username;
    private final boolean valid;

    public User(String username, boolean valid) {
        this.username = username;
        this.valid = valid;
    }

    public String getUsername() {
        return username;
    }

    public boolean isValid() {
        return valid;
    }

    public int getLength() {
        return length;
    }
}
