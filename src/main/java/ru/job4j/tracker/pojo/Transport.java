package ru.job4j.tracker.pojo;

public interface Transport {
    boolean ride();

    int count();

    int fuel(int price);
}
