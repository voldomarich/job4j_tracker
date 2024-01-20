package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.Input;
import ru.job4j.tracker.tracker.Item;
import ru.job4j.tracker.tracker.Output;
import ru.job4j.tracker.tracker.Tracker;

public class Delete implements User {

    private final Output out;

    public Delete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ===");
        int id = input.askInt("Enter ID: ");
        Item deletedItem = tracker.findById(id);
        if (tracker.delete(id)) {
            out.println("Заявка удалена успешно. " + deletedItem);
        } else {
            out.println("Что-то пошло не так, и заявка не удалилась.");
        }
        return true;
    }
}
