package ru.job4j.additional;

import java.util.List;
import java.util.Objects;

public class ArProgression {

    public static int checkData(List<Integer> data) {
        int sum = 0;
        for (int i = 0; i < data.size() - 1; i++) {
            if (Objects.equals(data.get(i + 1), (data.get(i) + data.get(i + 2)) / 2)) {
                for (Integer datum : data) {
                    sum += datum;
                }
            }
            return sum;
        }
        return sum;
    }
}
