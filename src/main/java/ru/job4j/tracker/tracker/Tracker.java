package ru.job4j.tracker.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.set(id, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}
