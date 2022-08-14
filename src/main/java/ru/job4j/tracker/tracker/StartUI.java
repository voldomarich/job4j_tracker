package ru.job4j.tracker.tracker;

import java.util.List;

public record StartUI(Output out) {

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
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
        List<UserAction> actions = List.of(
                new CreateHugeAction(output), new DeleteHugeAction(output),
                new CreateAction(output), new FindAllAction(output), new EditAction(output),
                new DeleteAction(output), new FindByIdAction(output),
                new FindByNameAction(output), new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
