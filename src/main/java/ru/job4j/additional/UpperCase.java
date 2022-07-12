package ru.job4j.additional;

public class UpperCase {

    public static char[] toUpperCase(char[] string) {
        char[] result = new char[string.length];
        int i = 0;
        for (char s : string) {
            result[i++] = Character.toUpperCase(s);
        }
        return result;
    }
}
