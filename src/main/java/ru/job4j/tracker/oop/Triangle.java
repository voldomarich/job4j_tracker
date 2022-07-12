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
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return ac + bc > ab && ab + ac > bc && ab + bc > ac;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    public static void main(String[] args) {
        Point a = new Point(3, 10);
        Point b = new Point(0, 6);
        Point c = new Point(10, 6);
        Triangle triangle = new Triangle(a, b, c);
        System.out.println(triangle.area());
    }
}
