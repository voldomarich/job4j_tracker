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
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        return sum(a) + minus(b) + multiply(c) + divide(d);
    }

    public static void main(String[] args) {
        int i = 0;
        System.out.println(sum(10));
        System.out.println(minus(21));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(8));
        System.out.println(calculator.divide(10));
        System.out.println(calculator.sumAllOperation(i));
    }
}
