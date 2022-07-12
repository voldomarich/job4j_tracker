package ru.job4j.additional;

import java.util.Map;

public class ComputeIfPresent {

    public static Map<Integer, String> collectData(Map<Integer, String> name, Map<Integer, String> surname) {
        for (Integer s : surname.keySet()) {
            name.computeIfPresent(s, (key, value) -> value + " " + surname.get(key));
        }
        return name;
    }
}
