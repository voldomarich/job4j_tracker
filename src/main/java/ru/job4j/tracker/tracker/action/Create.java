package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.*;

public class Create implements UserAction {

    private final Output out;

    public Create(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
