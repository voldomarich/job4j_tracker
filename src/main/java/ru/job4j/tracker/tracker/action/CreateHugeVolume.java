package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.Input;
import ru.job4j.tracker.tracker.Item;
import ru.job4j.tracker.tracker.Output;
import ru.job4j.tracker.tracker.Tracker;

public class CreateHugeVolume implements User {

    private final Output out;

    public CreateHugeVolume(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a lot of new items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create new Items ====");
        String name = input.askStr("Enter name: ");
        int n = 500_000;
        for (int i = 1; i < n + 1; i++) {
            Item item = new Item(name + i);
            tracker.add(item);
            out.println("Добавленная заявка: " + name + i);
        }
        return true;
    }
}
