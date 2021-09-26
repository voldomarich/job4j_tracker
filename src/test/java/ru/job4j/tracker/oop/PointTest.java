package ru.job4j.tracker.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(10, 12);
        Point b = new Point(21, 30);
        Point point = new Point(a, b);
        double rsl = point.distance(point);
        assertThat(rsl, closeTo(21.09, 0.001));
    }

    @Test
    public void distance3d() {
            Point a = new Point(0, 0, 11);
            Point b = new Point(6, 10, 10);
            Point point = new Point(a, b);
            double rsl = point.distance3d();
            assertThat(rsl, closeTo(11.7, 0.001));
        }
    }
