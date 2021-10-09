package ru.job4j.tracker.oop;

public class Surgeon extends Doctor {

    private String category;

    public Surgeon(String name, String surname, String education, String birthday, String level, String category) {
        super(name, surname, education, birthday, level);
        this.category = category;
    }
}
