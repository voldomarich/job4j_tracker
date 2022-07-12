package ru.job4j.additional;

import java.util.HashSet;
import java.util.Set;

public class Isogram {

    public static boolean checkString(String s) {
        Set<Character> set = new HashSet<>();
        for (char st : s.toCharArray()) {
            set.add(st);
        }
        return set.size() == s.length();
    }
}
