package ru.job4j.additional;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {
    public static List<String> sortList(List<String> list) {
        return list.removeIf(a -> a.length() < 5) ? list : new ArrayList<>();
    }
}
