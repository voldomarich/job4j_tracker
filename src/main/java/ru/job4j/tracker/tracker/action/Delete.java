package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.*;

public class Delete implements UserAction {

    private final Output out;

    public Delete(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Delete Item ===");
        int id = input.askInt("Enter ID: ");
        Item deletedItem = memTracker.findById(id);
        if (memTracker.delete(id)) {
            out.println("Заявка удалена успешно. " + deletedItem);
        } else {
            out.println("Что-то пошло не так, и заявка не удалилась.");
        }
        return true;
    }
}
