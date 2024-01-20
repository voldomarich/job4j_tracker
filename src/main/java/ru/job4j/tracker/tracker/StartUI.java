package ru.job4j.tracker.tracker;

import ru.job4j.tracker.tracker.action.*;

import java.util.List;

public record StartUI(Output out) {

    public void init(Input input, Tracker tracker, List<User> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            User action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<User> actions) {
        System.out.println();
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<User> actions = List.of(
                new CreateHugeVolume(output), new DeleteHugeVolume(output),
                new Create(output), new FindAll(output), new Edit(output),
                new Delete(output), new FindById(output),
                new FindByName(output), new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
