package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.Input;
import ru.job4j.tracker.tracker.Output;
import ru.job4j.tracker.tracker.Tracker;
import ru.job4j.tracker.tracker.UserAction;

public class DeleteHugeVolume implements UserAction {

    private final Output out;

    public DeleteHugeVolume(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete a huge amount of items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Items ===");
        int n = input.askInt("Enter ID1: ");
        for (int i = n; i > 0; i--) {
            tracker.delete(i);
            out.println("Заявки удалены успешно. ");
        }
        return true;
    }
}
