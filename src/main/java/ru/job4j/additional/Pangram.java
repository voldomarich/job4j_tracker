package ru.job4j.additional;

import java.util.HashSet;
import java.util.Set;

public class Pangram {

    public static boolean checkString(String s) {
        Set<Character> pangram = new HashSet<>();
        String t = s.replaceAll(" ", "");
        for (char ch : t.toCharArray()) {
            pangram.add(ch);
        }
        return pangram.size() == 26;
    }
}
