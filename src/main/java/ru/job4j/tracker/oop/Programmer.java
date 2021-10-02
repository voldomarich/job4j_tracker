package ru.job4j.tracker.oop;

public class Programmer extends Engineer {

    private String category;
    private String workPermit;

    public String getCategory() {
        return category;
    }

    public String getWorkPermit() {
        return workPermit;
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
