package ru.job4j.function;

import org.junit.Test;
import ru.job4j.lambda.FuncDiapason;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class FuncDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FuncDiapason.func(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        List<Double> result = FuncDiapason.func(5, 8, x -> 2 * Math.pow(x, 2) + 10 * x + 1);
        List<Double> expected = Arrays.asList(101D, 133D, 169D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenLinearResults() {
        List<Double> result = FuncDiapason.func(1, 4, x -> 2 * Math.pow(x, 6));
        List<Double> expected = Arrays.asList(2D, 128D, 1458D);
        assertThat(result, is(expected));
    }
}
