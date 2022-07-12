package ru.job4j.additional;

import java.util.Optional;

public class OptionalGetAndIsPresent {

    public static int get(int[] data, int el) {
        Optional<Integer> result = indexOf(data, el);
        return result.isEmpty() ? -1 : result.get();
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
