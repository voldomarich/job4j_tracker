package ru.job4j.tracker.oop;

public class Surgeon extends Doctor {

    private String category;

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Surgeon(String level) {
        super(level);
    }

    public void Surgeon(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String getEducation() {
        return super.getEducation();
    }

    @Override
    public String getBirthday() {
        return super.getBirthday();
    }

    @Override
    public String getLevel() {
        return super.getLevel();
    }
}
