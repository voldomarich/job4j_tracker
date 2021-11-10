package ru.job4j.tracker.ex;

public class FactRec {
    public static float calc(float n) {
        if (n <= 1) {
            return 1;
        }
        return calc(n - 1) * n;
        }

    public static void main(String[] args) {
        float rsl = calc(34);
        System.out.println(rsl);
    }
}
