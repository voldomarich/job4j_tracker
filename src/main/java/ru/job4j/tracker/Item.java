package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Чип для материнской платы" + name);
        System.out.println("ID" + id);
        System.out.println();
    }

    public static void main(String[] args) {
        Item first = new Item();
        first.printInfo();
        Item second = new Item("Чип для материнской платы");
        second.printInfo();
        Item third = new Item(20202021, "Чип для материнской платы");
        third.printInfo();
    }
}
