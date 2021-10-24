package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
        }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

        public Item[] findByName(String key) {
            Item[] rsl = new Item[size];
            for (int index = 0; index < size; index++) {
                Item item = rsl[index];
            if (item.getName().equals(key)) {
                rsl = items;
                break;
                }
            }
            return rsl;
        }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public int replace(Item item, int id) {
        boolean x = true;
        int index = indexOf(id);
        item[index].getId() = item;
        return x;
    }
}
