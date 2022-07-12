package ru.job4j.additional;

public class IndexOfWithCount {

    public static int indexOf(char[] string, char c, int number) {
        int rsl = -1;
        int n = 0;
        for (char i = 0; i < string.length; i++) {
            if (string[i] == c) {
                n++;
                if (n == number) {
                    rsl = i;
                }
            }
        }
        return rsl;
    }
}
