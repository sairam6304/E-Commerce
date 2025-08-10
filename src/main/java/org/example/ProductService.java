// src/main/java/org/example/ProductService.java
package org.example;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(int id, Product updatedProduct) {
        return productRepository.findById(id).map(existing -> {
            updatedProduct.setPid(id);
            return productRepository.save(updatedProduct);
        });
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}