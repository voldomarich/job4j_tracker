package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {

    private final List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        var rsl = new ArrayList<Person>();
        Predicate<Person> combName = (person) -> person.getName().contains(key);
        Predicate<Person> combSurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> combPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> combAddress = (person) -> person.getAddress().contains(key);
        Predicate<Person> combine = combName
                .or(combSurname)
                .or(combPhone)
                .or(combAddress);
        for (var person : persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}
