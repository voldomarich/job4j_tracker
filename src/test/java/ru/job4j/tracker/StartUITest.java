package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.oop.Input;
import ru.job4j.tracker.oop.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void createItem() {
            String[] answers = {"Fix PC"};
            Input input = new StubInput(answers);
            Tracker tracker = new Tracker();
            StartUI.createItem(input, tracker);
            Item created = tracker.findAll()[0];
            Item expected = new Item("Fix PC");
            assertThat(created.getName(), is(expected.getName()));
        }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "edited item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("edited item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "deleted item"
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = null;
        assertThat(deleted.getName(), is("deleted item"));
    }
}
