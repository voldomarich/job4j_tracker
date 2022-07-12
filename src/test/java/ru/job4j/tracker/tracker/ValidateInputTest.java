package ru.job4j.tracker.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(3));
    }

    @Test
    public void whenManyValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"3", "4", "5"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3, is(3));
        int selected4 = input.askInt("Enter menu:");
        assertThat(selected4, is(4));
        int selected5 = input.askInt("Enter menu:");
        assertThat(selected5, is(5));
    }

    @Test
    public void whenInputIsNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-8"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-8));
    }
}
