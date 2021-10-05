package ru.job4j.tracker.pojo;

public class Library {
    public static void main(String[] args) {
        Book ancientRome = new Book("Ancient Rome", 10);
        Book poetry = new Book("Poetry", 11);
        Book art = new Book("Art", 20);
        Book cleanCode = new Book("Clean code", 21);
        Book[] shelf = new Book[4];
        shelf[0] = ancientRome;
        shelf[1] = poetry;
        shelf[2] = art;
        shelf[3] = cleanCode;
        for (Book shel : shelf) {
            System.out.println(shel.getName() + " - " + shel.getCount());
        }
        System.out.println();
        System.out.println("Replace Ancient Rome to Clean code");
        Book temp = shelf[3];
        shelf[3] = shelf[0];
        shelf[0] = temp;
        for (Book shel : shelf) {
            System.out.println(shel.getName() + " - " + shel.getCount());
        }
        System.out.println();
        System.out.println("Shown only clean code");
        for (Book shel : shelf) {
            if ("Clean code".equals(shel.getName())) {
                System.out.println(shel.getName() + " - " + shel.getCount());
            }
        }
    }
}
