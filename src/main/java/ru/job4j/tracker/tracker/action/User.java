package ru.job4j.tracker.tracker.action;

import ru.job4j.tracker.tracker.Input;
import ru.job4j.tracker.tracker.Tracker;

public interface User {
    String name();

    boolean execute(Input input, Tracker tracker);
}
