package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.tracker.Item;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrackerHbmTest {

    private HbmTracker tracker;

    @BeforeEach
    public void setUp() {
        tracker = new HbmTracker();
        tracker.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        tracker.close();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenAddNewItemsThenFindTheseItemsInTrackerByName() {
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item item2 = new Item();
        item2.setName("test1");
        tracker.add(item2);
        List<Item> result = tracker.findByName("test1");
        assertThat(result).hasSameElementsAs(List.of(item, item2));
    }

    @Test
    public void whenReplaceItemThenReturnTrue() {
        Item item = new Item("test1");
        Item added = tracker.add(item);
        boolean replaced = tracker.replace(added.getId(), new Item("new name"));
        assertThat(replaced).isTrue();
        Item result = tracker.findById(added.getId());
        assertThat(result.getName()).isEqualTo("new name");
        List<Item> resultList = tracker.findByName("new name");
        assertThat(resultList.get(0)).isEqualTo(result);
    }

    @Test
    public void whenDeleteItemThenTrackerDoesNotHaveSameItem() {
        Item added = tracker.add(new Item("test1"));
        tracker.delete(added.getId());
        Item result = tracker.findById(added.getId());
        assertThat(result).isNull();
    }

    @Test
    public void whenFindAllThenReturnCountOfAllItems() {
        tracker.add(new Item("item1"));
        tracker.add(new Item("item2"));
        tracker.add(new Item("item3"));
        List<Item> items = tracker.findAll();
        assertThat(items).hasSize(3);
        tracker.deleteAll();
        List<Item> itemsEmpty = tracker.findAll();
        assertThat(itemsEmpty).hasSize(0);
    }

    @Test
    public void whenFindByNameThenReturnItemsWithSameName() {
        tracker.add(new Item("item1"));
        tracker.add(new Item("item2"));
        tracker.add(new Item("item3"));
        List<Item> items = tracker.findByName("item2");
        assertThat(items).hasSize(1);
        assertThat(items.get(0).getName()).isEqualTo("item2");
    }

    @Test
    public void whenFindByIdThenReturnCorrectItem() {
        Item item = new Item("test1");
        Item added = tracker.add(item);
        Item result = tracker.findById(added.getId());
        assertThat(result).isEqualTo(added);
    }
}
