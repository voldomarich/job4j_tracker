package ru.job4j.tracker.pojo;

public class BookShop {

        public static int indexOfNull(Book[] products) {
        int rsl = -1;
        for (int i = 0; i < products.length; i++) {
            Book product = products[i];
            if (product == null) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
