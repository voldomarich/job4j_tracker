package ru.job4j.additional;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class IsogramTest {

    @Test
    public void checkStringTrue() {
        String s = "uncopyrightables";
        boolean b = Isogram.checkString(s);
        assertThat(b, is(true));
    }

    @Test
    public void checkStringFalse() {
        String s = "javascript";
        boolean b = Isogram.checkString(s);
        assertThat(b, is(false));
    }
}
