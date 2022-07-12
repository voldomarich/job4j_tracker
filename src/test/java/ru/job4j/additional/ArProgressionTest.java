package ru.job4j.additional;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ArProgressionTest {

    @Test
    public void checkDataIsNotNull() {
        List<Integer> data = List.of(
                1, 6, 11, 16, 21,
                26, 31, 36, 41, 46
        );
        int rsl = ArProgression.checkData(data);
        assertThat(rsl, is(235));
    }

    @Test
    public void checkDataIsNull() {
        List<Integer> data = List.of(
                1, 6, 11, 15, 21,
                26, 31, 36, 41, 46
        );
        int rsl = ArProgression.checkData(data);
        assertThat(rsl, is(0));
    }

    @Test
    public void checkLastElement() {
        List<Integer> data = List.of(
                1, 6, 11, 15, 21,
                26, 31, 36, 41, 45
        );
        int rsl = ArProgression.checkData(data);
        assertThat(rsl, is(0));
    }
}
