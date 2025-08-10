package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProductServiceTest {
    ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void testGetProducts() {
        List<Product> result = productService.getAllProducts();
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void testGetProductById() {
        Product result = productService.getProductById(1).orElse(null);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getPid());
    }

    @Test
    void testAddProduct() {
        Product newProduct = new Product(null, "Monitor", 150.0, 5);
        Product result = productService.createProduct(newProduct);
        Assertions.assertNotNull(result.getPid());
        Assertions.assertEquals("Monitor", result.getName());
    }

    @Test
    void testUpdateProduct() {
        Product updated = new Product(null, "Updated Laptop", 1200.0, 8);
        productService.updateProduct(1, updated);
        Product result = productService.getProductById(1).orElse(null);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Updated Laptop", result.getName());
    }

    @Test
    void testDeleteProduct() {
        productService.deleteProduct(1);
        Assertions.assertTrue(productService.getProductById(1).isEmpty());
    }
}