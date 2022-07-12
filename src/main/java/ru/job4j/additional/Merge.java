package ru.job4j.additional;

public class Merge {

    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int a = 0;
        for (int row = 0; row < left.length; row++) {
            for (int cell = 0; cell < right.length; cell++) {
                if (left[row] < right[cell]) {
                    rsl[a++] = left[row];
                    break;
                } else if (left[row] == right[cell]) {
                    rsl[a++] = left[row];
                    rsl[a++] = right[cell];
                    break;
                }
                rsl[a++] = right[cell];
                }
            }
        return rsl;
    }
}
