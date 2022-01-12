package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public static List<Integer> convert(Integer[][] matrix) {
        matrix.flatMap(List::stream).stream().collect(Collectors.toList());
        return new ArrayList<>();
    }
}
