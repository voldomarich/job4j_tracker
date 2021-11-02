package ru.job4j.tracker.oop;

public class Boeing implements Vehicle {
    public void fly() {
        System.out.println(nameClass + "летит");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит на высоте 12 км");
    }
}
