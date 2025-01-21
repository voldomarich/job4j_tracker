package ru.job4j.tracker;

import ru.job4j.tracker.tracker.Item;

public class HQLUsage {
    public static void main(String[] args) {

        var itemRepository = new HbmTracker();

        System.out.println("creatingItem1");
        var item1 = new Item();
        item1.setName("bags");
        itemRepository.add(item1);
        System.out.println();

        System.out.println("creatingItem2");
        var item2 = new Item();
        item2.setName("clothes");
        itemRepository.add(item2);
        System.out.println();

        System.out.println("findAll");
        itemRepository.findAll()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("replace");
        System.out.println(itemRepository.replace(item1.getId(), new Item("food")));
        System.out.println();

        System.out.println("findByName");
        itemRepository.findByName("food")
                .forEach(System.out::println);
        System.out.println();

        System.out.println("findById");
        System.out.println(itemRepository.findById(item2.getId()));
        System.out.println();

        System.out.println("deletingItem2");
        itemRepository.delete(item2.getId());
        System.out.println();

        System.out.println("findAllAfterDeleting");
        itemRepository.findAll()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("deletingAllItemsInList");
        itemRepository.deleteAll();
        System.out.println();

        System.out.println("findAllAfterCompleteDeleting");
        itemRepository.findAll()
                .forEach(System.out::println);
        System.out.println();

    }
}
