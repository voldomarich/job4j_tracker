package ru.job4j.stream;

import ru.job4j.collection.Job;

import java.util.Comparator;
import java.util.Objects;

public class ThenComparingMethod {
    public static class User implements Comparable<User> {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
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
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(User another) {
            return Integer.compare(age, another.age);
        }

        public static Comparator<User> thenComparing(User first, User second) {
            return ascByName(first, second).thenComparing(descByAge(first, second));
        }

        public static Comparator<User> ascByName(User first, User second) {
            return new Comparator<User>() {
                @Override
                public int compare(User first, User second) {
                    return first.getName().compareTo(second.getName());
                }
            };
        }

        public static Comparator<User> descByAge(User first, User second) {
            return new Comparator<User>() {
                @Override
                public int compare(User first, User second) {
                    return Integer.compare(second.getAge(), first.getAge());
                }
            };
        }
    }
}
