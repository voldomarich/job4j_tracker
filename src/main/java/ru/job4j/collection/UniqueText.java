package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        int count = 0;
        for (String str : text) {
            if (!check.contains(str)) {
                count++;
            }
            if (count > 3) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
