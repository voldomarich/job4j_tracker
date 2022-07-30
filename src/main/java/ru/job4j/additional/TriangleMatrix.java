package ru.job4j.additional;

public class TriangleMatrix {

    public static int[][] rows(int count) {
        for (int i = 0; i < count; i++) {
            int[][] result = new int[i][count];
            for (int j = 1; j < result[i].length; j++) {
                result[i][j] = j;
            }
            return result;
        }
        return null;
    }
}
