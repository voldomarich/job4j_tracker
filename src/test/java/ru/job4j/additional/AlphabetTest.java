package ru.job4j.additional;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class AlphabetTest {

    @Test
    public void reformat() {
        String rsl = Alphabet.reformat("javascript");
        String expected = "aacijprstv";
        assertThat(rsl, is(expected));
    }

    @Test
    public void reformat1() {
        String rsl = Alphabet.reformat("websecurityconfigureradapter");
        String expected = "aabccdeeeefgiinoprrrrsttuuwy";
        assertThat(rsl, is(expected));
    }
}
