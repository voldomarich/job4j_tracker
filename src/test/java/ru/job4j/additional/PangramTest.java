package ru.job4j.additional;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class PangramTest {
    @Test
    public void checkString() {
        String str = "Jackdaws love my big sphinx of quartz";
        boolean b = Pangram.checkString(str);
        assertThat(b, is(true));
    }
}
