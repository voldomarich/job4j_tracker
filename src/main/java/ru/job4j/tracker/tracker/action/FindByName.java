package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.*;

import java.util.List;

public class FindByName implements UserAction {

    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item By Name";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("=== Find Item By Name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявок с введенным именем: " + name + " не найдена.");
        }
        return true;
    }
}
