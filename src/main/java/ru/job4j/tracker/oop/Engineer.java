package ru.job4j.tracker.oop;

public class Engineer extends Profession {

    private String level;

    public void Engineer(String level) {
        this.level = level;
    }

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getLevel() {
        return level;
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
}
