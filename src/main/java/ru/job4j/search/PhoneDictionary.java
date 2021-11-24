package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {

    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> rsl = new ArrayList<>();
        for (Person person : persons) {
        if  (key.contains(person.getName()) || key.contains(person.getSurname())
        || key.contains(person.getPhone()) || key.contains(person.getAddress())) {
            rsl.add(person);
        }
        }
        return rsl;
    }
}
