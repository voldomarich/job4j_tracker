package ru.job4j.tracker.encapsulation;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LicenseTest {

        @Test
        public void eqName() {
            License first = new License();
            first.setCode("audio");
            License second = new License();
            second.setCode("audio");
            assertThat(first, is(second));
        }
    }
