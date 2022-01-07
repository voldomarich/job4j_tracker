package ru.job4j.collection;

import java.util.Comparator;

public class DempDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] a = o1.split("/");
        String[] b = o2.split("/");
        int i = b[0].compareTo(a[0]);
        return i == 0 ? o1.compareTo(o2) : i;
    }
}
