package ru.job4j.additional;

import java.util.Arrays;
import java.util.Optional;

public class OptionalIfPresent {

    public static void ifPresent(int[] data) {
        max(data).ifPresent(a -> System.out.println("Max: " + a));
    }

    private static Optional<Integer> max(int[] data) {
        Arrays.sort(data);
        return data.length > 0 ? Optional.of(data[data.length - 1]) : Optional.empty();
    }
}
