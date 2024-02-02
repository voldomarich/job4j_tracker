package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.Input;
import ru.job4j.tracker.tracker.Output;
import ru.job4j.tracker.tracker.MemTracker;
import ru.job4j.tracker.tracker.UserAction;

public class Exit implements UserAction {

    private final Output out;

    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}
