package ru.job4j.additional;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {

    public static int generateAndSum(int first, int denominator, int count) {
        List<Integer> array = new ArrayList<>();
        int result = 0;
        int sum = 0;
        for (Integer i : array) {
            while (count > 0) {
                i = i * denominator;
                array.set(result++, i);
                i =
                        sum += i;
                count--;
            }
        }
        return sum;
    }
}
