package ru.job4j.tracker.tracker;

import org.junit.Test;
import ru.job4j.tracker.tracker.action.Delete;
import ru.job4j.tracker.tracker.action.Edit;
import ru.job4j.tracker.tracker.action.FindById;
import ru.job4j.tracker.tracker.action.FindByName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTrackerTest {

    private final Output output = new StubOutput();
    private final MemTracker tracker = new MemTracker();
    private final String ln = System.lineSeparator();

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Edit replaceAction = new Edit(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit Item ===" + ln
                        + "Заявка до редактирования: " + item + ln
                        + "Заявка изменена успешно: " + tracker.findById(1) + ln
        );
    }

    @Test
    public void whenItemWasReplacedSuccesslessly() {
        Edit replaceAction = new Edit(output);
        Input input = mock(Input.class);
        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit Item ===" + ln
                        + "Заявка до редактирования: " + tracker.findById(1) + ln
                        + "Ошибка замены заявки." + ln);
    }

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Item item = tracker.add(new Item("ToBeDeleted item"));
        Delete deleteAction = new Delete(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);

        assertThat(output.toString()).isEqualTo(
                "=== Delete Item ===" + ln
                        + "Заявка удалена успешно. "
                        + item.toString() + ln);
    }

    @Test
    public void  whenItemWasFoundById() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("ToBeFoundById item"));
        tracker.add(item);
        FindById findByIdAction = new FindById(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(4);
        when(input.askInt(any(String.class))).thenReturn(2);
        findByIdAction.execute(input, tracker);
        String string = item.toString();
        assertThat(output.toString()).isEqualTo("=== Find Item By ID ===" + ln + string + ln);
    }

    @Test
    public void  whenItemWasFoundByName() {
        Item item = tracker.add(new Item("ToBeFoundByName item"));
        tracker.add(item);
        FindByName findByNameAction = new FindByName(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(5);
        when(input.askStr(any(String.class))).thenReturn("ToBeFoundByName item");
        findByNameAction.execute(input, tracker);
        String string = item.toString();
        assertThat(output.toString()).isEqualTo("=== Find Item By Name ===" + ln + string
                + ln + string + ln);
    }
}
