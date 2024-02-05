package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.*;

public class Edit implements UserAction {
    private final Output out;

    public Edit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Edit Item ===");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter name: ");
        out.println("Заявка до редактирования: " + memTracker.findById(id));
        Item item = new Item(name);
        if (memTracker.replace(id, item)) {
            out.println("Заявка изменена успешно: " + memTracker.findById(id));
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
