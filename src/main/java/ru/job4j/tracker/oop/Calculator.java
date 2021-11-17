package ru.job4j.tracker.oop;

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

    public int sumAllOperation(int i) {
        return sum(i) + minus(i) + multiply(i) + divide(i);
    }

    public static void main(String[] args) {
        System.out.println(sum(100));
        System.out.println(minus(100));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(100));
        System.out.println(calculator.divide(100));
        System.out.println(calculator.sumAllOperation(100));
    }
}
