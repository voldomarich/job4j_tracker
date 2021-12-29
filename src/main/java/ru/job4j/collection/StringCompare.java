package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int i = 0;
        for (int l = 0; l < left.length(); l++) {
            for (int r = 0; r < right.length(); r++) {
                i = Character.compare(left.charAt(l), right.charAt(r));
                break;
            }
        }
        return i;
    }
}
