package ru.job4j.tracker.pojo;

public class ShopDrop {
    public static Book[] delete(Book[] products, int index) {
        products[0] = new Book("Uncle Tom's cabin", 100);
        products[1] = new Book("Gone with the wind", 11);
        products[2] = new Book("The Corrections", 21);
        for (int i = 1; i < products.length - index; i++) {
            products[index] = products[index + i];
            products[index + i] = null;
        }
        for (Book product : products) {
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        return products;
    }
}
