package ru.job4j.additional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Merge1 {

    public static Map<Integer, String> collectData(Map<Integer, String> names, List<User> users) {
        for (User user : users) {
            names.putIfAbsent(user.getId(), user.getName());
            names.merge(user.getId(), user.getSurname(), (oldV, newV) -> oldV + " " + newV);
        }
        return names;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int a = 0;
        for (int row = 0; row < left.length; row++) {
            for (int cell = 0; cell < right.length; cell++) {
                if (left[row] < right[cell]) {
                    rsl[a++] = left[row];
                    break;
                } else if (left[row] == right[cell]) {
                    rsl[a++] = left[row];
                    rsl[a++] = right[cell];
                    break;
                }
                rsl[a++] = right[cell];
            }
        }
        return rsl;
    }

    public static class User {
        private int id;
        private String name;
        private String surname;

        public User(int id, String name, String surname) {
            this.id = id;
            this.name = name;
            this.surname = surname;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
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
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
