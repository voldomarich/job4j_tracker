package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            for (String w : text) {
                check.add(word);
                check.add(w);
            for (String c : check) {
                if (check.size() > origin.length) {
                    rsl = false;
                    break;
                }
                }
            }
        }
        return rsl;
    }
}
