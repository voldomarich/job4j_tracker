package ru.job4j.tracker.oop;

public class Builder extends Engineer {

    private String category;
    private String workPermit;

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void Builder(String category, String workPermit) {
        this.category = category;
        this.workPermit = workPermit;
    }

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

    @Override
    public String getSpeciality() {
        return super.getSpeciality();
    }

    @Override
    public String getLevel() {
        return super.getLevel();
    }
}
