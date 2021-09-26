package ru.job4j.tracker.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TriangleTest {

    @Test
    public void area() {

            Point a = new Point(0, 0);
            Point b = new Point(4, 0);
            Point c = new Point(0, 4);
            Triangle triangle = new Triangle(a, b, c);
            double rsl = triangle.area();
            assertThat(rsl, closeTo(8, 0.001));
        }

    @Test
    public void area1() {

        Point a = new Point(3, 10);
        Point b = new Point(0, 6);
        Point c = new Point(10, 6);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(19.63, 0.033));
    }
    }
