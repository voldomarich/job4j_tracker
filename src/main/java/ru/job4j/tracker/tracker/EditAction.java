package ru.job4j.tracker.tracker;

public class EditAction implements UserAction {

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно. " + id);
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
