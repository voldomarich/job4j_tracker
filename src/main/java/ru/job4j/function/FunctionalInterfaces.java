package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");

        BiConsumer<Integer, String> biCon = (s, s1) -> System.out.println(s + s1);
        for (Integer key : map.keySet()) {
            biCon.accept(key, ". " + map.get(key));
        }

        BiPredicate<Integer, String> biPred = (i, s)
                -> i % 2 == 0 || map.get(i).length() == 4;
        for (Integer i : map.keySet()) {
            biPred.test(i, map.get(i));
            System.out.println("key: " + i + " value: " + map.get(i));
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : strings) {
            con.accept(s);
            func.apply(s);
        }
    }
}
