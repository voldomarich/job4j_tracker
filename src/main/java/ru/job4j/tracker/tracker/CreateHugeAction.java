package ru.job4j.tracker.tracker;

import java.util.LinkedList;
import java.util.List;

public class CreateHugeAction implements UserAction {

    private final Output out;

    public CreateHugeAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a lot of new items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create new Items ====");
        List<Item> items = new LinkedList<>();
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        items.add(item);
        for (Item i : items) {
            tracker.add(i);
            out.println("Добавленная заявка: " + i);
        }
        return true;
    }
}
