package ru.job4j.tracker.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (Point.distance(a, b) + Point.distance(b, c) + Point.distance(a, c)) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return ac + bc > ab && ab + ac > bc && ab + bc > ac ? true : false;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            rsl = sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }
}
