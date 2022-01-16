package ru.job4j.stream;

import java.time.LocalDate;

public class Car {
    private String brand;

    private String model;

    private LocalDate created;

    private double volume;

    private String color;

    private String price;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", created=" + created +
                ", volume=" + volume +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;
        private String price;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildPrice(String price) {
            this.price = price;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            car.price = price;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildBrand("Toyota")
                .buildModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .buildPrice("2 100 000 rub")
                .build();
        System.out.println(car);

        Car carAnother = new Builder()
                .buildBrand("Opel")
                .buildModel("Insignia")
                .buildCreated(LocalDate.of(2019, 6, 1))
                .buildVolume(2.0)
                .buildColor("Brown")
                .buildPrice("2 200 000 rub")
                .build();
        System.out.println(car);
    }
}
