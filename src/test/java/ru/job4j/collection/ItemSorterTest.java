package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.tracker.tracker.Item;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemSorterTest {
    @Test
    public void main() {
        List<Item> items = Arrays.asList(
                new Item(11, "Fix bugs", LocalDateTime.now()),
                new Item(8, "Reboot server", LocalDateTime.now()),
                new Item(10, "Impl task", LocalDateTime.now())
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(11, "Fix bugs", LocalDateTime.now()),
                new Item(10, "Impl task", LocalDateTime.now()),
                new Item(8, "Reboot server", LocalDateTime.now())
        );
        assertThat(items, is(expected));
    }

    @Test
    public void reverse() {
        List<Item> items = Arrays.asList(
                new Item(11, "Fix bugs", LocalDateTime.now()),
                new Item(8, "Reboot server", LocalDateTime.now()),
                new Item(10, "Impl task", LocalDateTime.now())
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(8, "Reboot server", LocalDateTime.now()),
                new Item(10, "Impl task", LocalDateTime.now()),
                new Item(11, "Fix bugs", LocalDateTime.now())
        );
        assertThat(items, is(expected));
    }
}
