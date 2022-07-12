package ru.job4j.additional;

public class MaxLengthSeria {

    public static int find(int[] array) {
        int n = 1;
        int nMax = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                n++;
            } else {
                if (n > nMax) {
                    nMax = n;
                    n = 1;
                }
            }
            }
        return n;
    }
}
