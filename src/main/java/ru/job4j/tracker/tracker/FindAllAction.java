package ru.job4j.tracker.tracker;

import java.awt.*;
import java.util.ArrayList;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = new ArrayList<>();
        items.add(tracker.findAll());
        if (items.size() > 0) {
            for (Item item : items) {
                out.println("Список заявок: " + item);
            }
        } else {
            out.println("Хранилище ещё не содержит заявок");
        }
        return true;
    }
}
