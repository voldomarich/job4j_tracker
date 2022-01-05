package ru.job4j.collection;

import java.util.Comparator;
import java.util.Set;

public class DempDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int z = 0;
        String[] a = o1.split("/");
        String[] b = o2.split("/");
        int i = b[0].compareTo(a[0]);
        if (i == 0) {
            for (int x = 1; x < a.length; x++) {
                for (int y = 1; y < b.length; y++) {
                    z = a[x].compareTo(b[y]);
                }
            }
        }
        return z;
    }
}
