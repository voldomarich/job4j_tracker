package ru.job4j.tracker.pojo;

public class Bus implements Transport {
    @Override
    public boolean ride() {
        return true;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int fuel(int sum) {
        return sum;
    }
}
