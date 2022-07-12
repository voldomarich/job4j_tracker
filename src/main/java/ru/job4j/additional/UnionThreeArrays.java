package ru.job4j.additional;

public class UnionThreeArrays {

    public static int[] union(int[] left, int[] middle, int[] right) {
        int[] result = new int[right.length + 1];
        for (int i = 0; i < right.length - 1; i++) {
            if (i % 2 == 1) {
                result[i + 1] = middle[i];
            }
            if (i % 2 == 0) {
                result[i + 1] = right[i];
            }
            result[0] = left[0];
            result[right.length] = left[left.length - 1];
        }
        return result;
    }
}
