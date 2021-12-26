package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemSorterTest {
    @Test
    public void main() {
        List<Item> items = Arrays.asList(
                new Item(11, "Fix bugs"),
                new Item(8, "Reboot server"),
                new Item(10, "Impl task")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(11, "Fix bugs"),
                new Item(10, "Impl task"),
                new Item(8, "Reboot server")
        );
        assertThat(items, is(expected));
    }

    @Test
    public void reverse() {
        List<Item> items = Arrays.asList(
                new Item(11, "Fix bugs"),
                new Item(8, "Reboot server"),
                new Item(10, "Impl task")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(8, "Reboot server"),
                new Item(10, "Impl task"),
                new Item(11, "Fix bugs")
        );
        assertThat(items, is(expected));
    }
}
