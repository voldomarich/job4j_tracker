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
        for (int i = 1; i < n; i++) {
            tracker.delete(i);
            out.println("Заявки удалены успешно. ");
            i--;
        }
        out.println("Что-то пошло не так, и заявки не удалились.");
        return true;
    }
}
