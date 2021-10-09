package ru.job4j.tracker.oop;

public class Doctor extends Profession {

    private String level;

    public Doctor(String name, String surname, String education, String birthday, String level) {
        super(name, surname, education, birthday);
        this.level = level;
    }
}
