package ru.job4j.additional;

public class Initials {

    public static String convert(String[] fio) {
        StringBuilder builder = new StringBuilder();
        builder.append(fio[0]).append(" ").append(fio[1].charAt(0)).append(".").append(fio[2].charAt(0)).append(".");
        return builder.toString();
    }
}
