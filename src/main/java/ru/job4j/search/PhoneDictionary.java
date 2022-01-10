package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        ArrayList<Person> rsl = new ArrayList<>();
        Predicate<Person> combine = (person) -> person.getName().contains(key)
                | person.getSurname().contains(key)
                | person.getPhone().contains(key)
                | person.getAddress().contains(key);
        for (Person person : persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}
