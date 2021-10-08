package ru.job4j.tracker.oop;

public class Profession {
    private final String name;
    private final String surname;
    private final String education;
    private final String birthday;
    private final String level;
    private final String category;

    public Profession(String name, String surname, String education, String birthday, String level, String category) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
        this.level = level;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLevel() {
        return level;
    }

    public String getCategory() {
        return category;
    }
}
