package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> deps) {
        Collections.sort(deps, Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> deps) {
        Collections.sort(deps, new DempDescComp());
    }
}
