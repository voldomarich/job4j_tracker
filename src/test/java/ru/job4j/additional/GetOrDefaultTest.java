package ru.job4j.additional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class GetOrDefaultTest {

    @Test
    public void whenGetList() {
        List<String> first = List.of("one", "two", "three");
        List<String> second = List.of("four", "five", "six");
        GetOrDefault get = new GetOrDefault();
        get.addValue(1, first);
        get.addValue(2, second);
        List<String> value = get.getValue(2);
        assertThat(value, is(second));
    }

    @Test
    public void whenGetListEmpty() {
        List<String> first = List.of("one", "two", "three");
        List<String> second = List.of("four", "five", "six");
        GetOrDefault get = new GetOrDefault();
        get.addValue(1, first);
        get.addValue(2, second);
        List<String> value = get.getValue(10);
        assertThat(value, is(new ArrayList<>()));
    }

    @Test
    public void whenAddListWithDuplicateKey() {
        List<String> first = List.of("one", "two", "three");
        List<String> second = List.of("four", "five", "six");
        List<String> third = List.of("seven", "eight", "nine");
        GetOrDefault get = new GetOrDefault();
        get.addValue(1, first);
        get.addValue(2, second);
        get.addValue(1, third);
        List<String> value = get.getValue(1);
        assertThat(value, is(first));
    }
}
