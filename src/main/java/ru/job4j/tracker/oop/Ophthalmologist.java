package ru.job4j.tracker.oop;

public class Ophthalmologist extends Doctor {

    private String category;

    public Ophthalmologist(String name, String surname, String education,
                           String birthday, String level, String category) {
        super(name, surname, education, birthday, level);
        this.category = category;
    }
}
