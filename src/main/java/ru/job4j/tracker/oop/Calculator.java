package ru.job4j.tracker.oop;

import java.util.concurrent.Callable;

public class Calculator {

    private static int x = 5;

    public static int sum(int a) {
        return a + x;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int multiply(int c) {
        return c * x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int rsl) {
        return a + b + c + d;
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println(minus(21));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(8));
        System.out.println(calculator.divide(2));
        System.out.println(calculator.sumAllOperation());
    }
}
