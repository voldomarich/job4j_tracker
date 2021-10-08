package ru.job4j.tracker.oop;

public class Ophthalmologist extends Doctor {

    private String category;

    public Ophthalmologist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Ophthalmologist(String level) {
        super(level);
    }

    public void Ophthalmologist(String category) {
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
