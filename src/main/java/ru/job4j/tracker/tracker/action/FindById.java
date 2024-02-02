package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.*;

public class FindById implements UserAction {
    private final Output out;

    public FindById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item By ID";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("=== Find Item By ID ===");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
