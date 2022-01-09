package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FuncDiapason {
    public static List<Double> func(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {
            Consumer<Double> con = rsl::add;
            con.accept(func.apply((double) i));
        }
        return rsl;
    }
}
