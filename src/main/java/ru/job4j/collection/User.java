package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User> {

    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o1, User o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static Comparator<User> thenComparing() {
        return ascByName().thenComparing(descByAge());
    }

    public static Comparator<User> ascByName(User first, User second) {
        return first.getName().compareTo(second.getName());
    }

    public static Comparator<User> descByAge(User first, User second) {
        return Integer.compare(second.getAge(), first.getAge());
    }
}
