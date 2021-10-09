package ru.job4j.tracker.oop;

public class Programmer extends Engineer {

    private String category;

    public Programmer(String name, String surname, String education, String birthday, String level, String category) {
        super(name, surname, education, birthday, level);
        this.category = category;
    }
}
