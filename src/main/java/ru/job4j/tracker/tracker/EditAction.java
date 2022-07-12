package ru.job4j.tracker.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ===");
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter name: ");
        out.println("Заявка до редактирования: " + tracker.findById(id));
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена успешно: " + tracker.findById(id));
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
