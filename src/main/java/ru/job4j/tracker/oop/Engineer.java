package ru.job4j.tracker.oop;

public class Engineer extends Profession {

    private String speciality;
    private String level;

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Engineer(String speciality, String level) {
        this.speciality = speciality;
        this.level = level;
    }

    public String getSpeciality() {
        return speciality;
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
