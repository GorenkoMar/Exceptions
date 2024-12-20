package ru.netology.javaqa.exceptions.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(1, "Книга", 400);
    Product product2 = new Product(2, "Блокнот", 470);
    Product product3 = new Product(3, "Календарь", 500);


    @Test
    public void addProductsTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.findAll();
        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);
        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findProductTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.findById(2);
        Product expected = product2;
        Product actual = repo.findById(2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeNotFoundProductTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(4);
        });
    }
}


