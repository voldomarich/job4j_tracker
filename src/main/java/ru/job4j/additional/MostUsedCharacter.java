package ru.job4j.additional;

import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class MostUsedCharacter {

    public static char getMaxCount(String str) {
        Map<Character, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        String s = str.replaceAll(" ", "").toLowerCase(Locale.ROOT);
        int count = 1;
        for (char ch : s.toCharArray()) {
            map.putIfAbsent(ch, count);
            map.computeIfPresent(ch, (key, value) -> count + 1);
        }
        return map.entrySet().stream().findFirst().get().getKey();
    }
}
