package ru.job4j.tracker.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
            products[products.length - 1] = null;
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product.getName());
                } else {
                    System.out.println("null");
                }
            }
        return products;
    }
}
