// src/test/java/org/example/ProductControllerTest.java
package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    public ProductControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = List.of(new Product(1, "name", 10.0, 5));
        when(productService.getAllProducts()).thenReturn(products);

        List<Product> result = productController.getAllProducts();

        assertEquals(products, result);
        verify(productService).getAllProducts();
    }

    @Test
    void testGetProductById_Found() {
        Product product = new Product(1, "name", 10.0, 5);
        when(productService.getProductById(1)).thenReturn(Optional.of(product));

        ResponseEntity<Product> response = productController.getProductById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService).getProductById(1);
    }

    @Test
    void testGetProductById_NotFound() {
        when(productService.getProductById(1)).thenReturn(Optional.empty());

        ResponseEntity<Product> response = productController.getProductById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(productService).getProductById(1);
    }

    @Test
    void testAddProduct() {
        Product product = new Product(null, "name", 10.0, 5);
        Product saved = new Product(1, "name", 10.0, 5);
        when(productService.createProduct(product)).thenReturn(saved);

        ResponseEntity<Product> response = productController.addProduct(product);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(saved, response.getBody());
        verify(productService).createProduct(product);
    }

    @Test
    void testUpdateProduct_Found() {
        Product updatedProduct = new Product(1, "newName", 20.0, 10);
        when(productService.updateProduct(eq(1), any(Product.class))).thenReturn(Optional.of(updatedProduct));

        ResponseEntity<Product> response = productController.updateProduct(1, updatedProduct);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
        verify(productService).updateProduct(1, updatedProduct);
    }

    @Test
    void testUpdateProduct_NotFound() {
        Product updatedProduct = new Product(1, "newName", 20.0, 10);
        when(productService.updateProduct(eq(1), any(Product.class))).thenReturn(Optional.empty());

        ResponseEntity<Product> response = productController.updateProduct(1, updatedProduct);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(productService).updateProduct(1, updatedProduct);
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productService).deleteProduct(1);

        ResponseEntity<Void> response = productController.deleteProduct(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(productService).deleteProduct(1);
    }
}