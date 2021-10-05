package ru.job4j.tracker.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(10, 12);
        Point b = new Point(21, 30);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(21.095, 0.001));
    }

    @Test
    public void distance3d() {
            Point a = new Point(0, 0, 11);
            Point b = new Point(6, 10, 10);
            double rsl = a.distance3d(b);
            assertThat(rsl, closeTo(11.705, 0.001));
        }
    }
