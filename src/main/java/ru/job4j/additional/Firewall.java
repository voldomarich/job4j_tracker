package ru.job4j.additional;

import java.util.Set;

public class Firewall {

    public static String checkName(String s, Set<String> words) {
        String[] strings = s.split(" ");
        for (String st : strings) {
            if (words.contains(st)) {
                return "Выберите другую статью...";
            }
        }
        return "Вы сделали правильный выбор!";
    }
}
