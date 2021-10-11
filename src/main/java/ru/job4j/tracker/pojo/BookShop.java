package ru.job4j.tracker.pojo;

public class BookShop {
        public static int indexOfNull(Product[] products) {
        int rsl = -1;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
