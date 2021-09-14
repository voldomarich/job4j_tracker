package ru.job4j.tracker.ex;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenMinus1() {
        int rsl = Fact.calc(-1);
        assertThat(rsl, is("Input should be positive number."));
    }

    @Test
    public void when8() {
        int rsl = Fact.calc(7);
        assertThat(rsl, is(5040));
    }
}
