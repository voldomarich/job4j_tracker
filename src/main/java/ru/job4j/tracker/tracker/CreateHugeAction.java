package ru.job4j.tracker.tracker;

public class CreateHugeAction implements UserAction {

    private final Output out;

    public CreateHugeAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create a lot of new items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create new Items ====");
        String name = input.askStr("Enter name: ");
        int n = 500_000;
        for (int i = 1; i < n + 1; i++) {
            Item item = new Item(name);
            tracker.add(item);
            out.println("Добавленная заявка: " + i);
            i++;
        }
        return true;
    }
}
