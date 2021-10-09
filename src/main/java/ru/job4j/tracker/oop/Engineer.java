package ru.job4j.tracker.oop;

public class Engineer extends Profession {

    private String level;

    public Engineer(String name, String surname, String education, String birthday, String level) {
        super(name, surname, education, birthday);
        this.level = level;
    }
}
