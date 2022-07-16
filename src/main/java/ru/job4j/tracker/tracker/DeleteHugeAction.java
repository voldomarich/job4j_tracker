package ru.job4j.tracker.tracker;

import java.util.ArrayList;
import java.util.List;

public class DeleteHugeAction implements UserAction {

    private final Output out;

    public DeleteHugeAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete a huge amount of items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Items ===");
        int id1 = input.askInt("Enter ID1: ");
        int id2 = input.askInt("Enter ID2: ");
        List<Integer> ids = new ArrayList<>();
        for (int i = id1; i <= id2; i++) {
            ids.add(i);
        }
        List<Item> deletedItems = new ArrayList<>();
        for (Integer id : ids) {
            Item deletedItem = tracker.findById(id);
            deletedItems.add(deletedItem);
            tracker.delete(id);
            ids.remove(id);
        }
        if (ids.size() == 0) {
            out.println("Заявки удалены успешно. " + deletedItems);
        }
        out.println("Что-то пошло не так, и заявки не удалились.");
        return true;
    }
}
