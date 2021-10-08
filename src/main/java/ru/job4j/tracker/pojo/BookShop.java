package ru.job4j.tracker.pojo;

public class BookShop {
        public static int indexOfNull(Book[] products) {
        int rsl = -1;
        products[0] = new Book("Uncle Tom's cabin", 100);
        products[1] = new Book("Gone with the wind", 11);
        products[2] = new Book("The Corrections", 21);
        for (int i = 0; i < products.length; i++) {
            Book product = products[i];
            rsl = i;
            if (product == null) {
                System.out.println(rsl);
            }
        }
        return rsl;
    }
}
