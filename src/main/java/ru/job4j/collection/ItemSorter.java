package ru.job4j.collection;

import ru.job4j.tracker.tracker.Item;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(11, "Fix bugs", LocalDateTime.now()),
                new Item(8, "Reboot server", LocalDateTime.now()),
                new Item(10, "Impl task", LocalDateTime.now())
        );
        System.out.println(items);
        Collections.sort(items, new ItemAscByName());
        System.out.println(items);
        Collections.sort(items, new ItemDescByName());
        System.out.println(items);
    }
}
