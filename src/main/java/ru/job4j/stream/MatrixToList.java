package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static List<Integer> convert(Integer[][] matrix) {
            Stream.of(matrix).flatMap().collect(Collectors.toList());
            return new ArrayList<>();
        }
    }
