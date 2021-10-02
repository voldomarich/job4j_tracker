package ru.job4j.tracker.oop;

public class Doctor extends Profession {

    private String speciality;
    private String level;

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
