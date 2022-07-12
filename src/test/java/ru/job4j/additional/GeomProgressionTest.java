package ru.job4j.additional;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class GeomProgressionTest {

    @Test
    public void generateAndSum() {
        int rsl = GeomProgression.generateAndSum(1, 3, 10);
        assertThat(rsl, is(29524));
    }

    @Test
    public void generateAndSumIs0() {
        int rsl = GeomProgression.generateAndSum(1, -1, 10);
        assertThat(rsl, is(0));
    }
}
