package ru.job4j.tracker;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;
    private String key = "";

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll(int id, String key) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            String name = Item[index];
            if (id != null) {
                Item[size] = name;
                size++;
            }
        }
        return rsl;

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
            Item rsl = "";
            for (int index = 0; index < size; index++) {
                Item item = items[index];
                if (item.getName() == key) {
                    rsl = item;
                    break;
                }
            }
            return rsl;
        }
}
