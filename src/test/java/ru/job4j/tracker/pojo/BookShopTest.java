package ru.job4j.tracker.pojo;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BookShopTest {
        @Test
        public void whenLastNull() {
            Product[] products = new Product[5];
            products[0] = new Product("Uncle Tom's cabin", 100);
            products[1] = new Product("Gone with the wind", 11);
            products[2] = new Product("The Corrections", 21);
            int rsl = BookShop.indexOfNull(products);
            assertThat(rsl, is(3));
        }

        @Test
        public void whenFirstNull() {
            Product[] products = new Product[5];
            products[1] = new Product("Gone with the wind", 11);
            int rsl = BookShop.indexOfNull(products);
            assertThat(rsl, is(0));
        }

        @Test
        public void whenHasNotNull() {
            Product[] products = new Product[1];
            products[0] = new Product("The Corrections", 21);
            int rsl = BookShop.indexOfNull(products);
            assertThat(rsl, is(-1));
        }
    }
