package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int l = 0; l < minLength; l++) {
            int rsl = Character.compare(left.charAt(l), right.charAt(l));
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
