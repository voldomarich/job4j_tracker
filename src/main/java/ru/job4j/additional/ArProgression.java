package ru.job4j.additional;

import java.util.List;

public class ArProgression {

    public static int checkData(List<Integer> data) {
        int sum = data.get(0) + data.get(1);
        for (int i = 2; i < data.size(); i++) {
            if (data.get(i - 1) != (data.get(i) + data.get(i - 2)) / 2) {
                sum = 0;
                break;
            }
            sum += data.get(i);
        }
        return sum;
    }
}
