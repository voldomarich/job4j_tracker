package ru.job4j.tracker.tracker;

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
        int n = input.askInt("Enter ID1: ");
        for (int i = n; i > 0; i--) {
            tracker.delete(i);
            out.println("Заявки удалены успешно. ");
        }
        return true;
    }
}
