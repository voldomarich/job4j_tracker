package ru.job4j.tracker.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter ID: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно. " + id);
        } else {
            System.out.println("Что-то пошло не так, и заявка не удалилась.");
        }
        return true;
    }
}
