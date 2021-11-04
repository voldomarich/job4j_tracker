package ru.job4j.tracker.oop;

public class Electrobus implements Vehicle {

    public void ride() {
        System.out.println(getClass().getSimpleName() + "едет по автодороге");
    }

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит на электродвигателе");
    }
}
