package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    public static String comp(String left, String right) {
        if (!left.equals(null) && !right.equals(null)) {
            for (int l = 0; l < left.length(); l++) {
                for (int r = 0; r < right.length(); r++) {
                    Character.compare(left.charAt(l), right.charAt(r));
                }
            }
        }
        return  null;
    }

    @Override
    public int compare(String left, String right) {
        return left.compareTo(right);
    }
}
