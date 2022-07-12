package ru.job4j.additional;

import java.util.*;

public class Alphabet {

    public static String reformat(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String[] strings = s.split("");
        for (String st : strings) {
            list.add(st);
            list.sort(Comparator.naturalOrder());
        }
        for (String l : list) {
            result.append(l);
        }
        return result.toString();
    }
}
