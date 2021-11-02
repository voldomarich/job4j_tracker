package ru.job4j.tracker.oop;

public class Lastochka implements Vehicle {
    public void rail() {
        System.out.println(nameClass + "едет по рельсам");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " мчится со скоростью 150 км/ч");
    }
}
