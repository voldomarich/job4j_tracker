package ru.job4j.tracker.oop;

public class Usage {
    public static void main(String[] args) {
        Vehicle airbus = new Airbus();
        Vehicle boeing = new Boeing();
        Vehicle electrobus = new Electrobus();
        Vehicle microbus = new Microbus();
        Vehicle sapsan = new Sapsan();
        Vehicle lastochka = new Lastochka();

        Vehicle[] vehicles = new Vehicle[]{airbus, boeing, electrobus, microbus, sapsan, lastochka};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
