package ru.job4j.tracker.oop;

public class Sapsan implements Vehicle {
    public void rail() {
        System.out.println(getClass().getSimpleName() + "едет по рельсам");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " мчится со скоростью 220 км/ч");
    }
}
