package ru.job4j.tracker.oop;

public class Airbus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летит на высоте 10 км");
    }
}
