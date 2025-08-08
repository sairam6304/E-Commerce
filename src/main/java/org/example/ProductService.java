package org.example;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductService {
    Map<Integer, Product> products = new HashMap<>();

    public ProductService() {
        // Initializing with some sample products
        products.put(1, new Product(1, "Laptop", 10, 999.99));
        products.put(2, new Product(2, "Smartphone", 20, 499.99));
        products.put(3, new Product(3, "Tablet", 15, 299.99));
    }

    public List<Product> getProducts() {
        return products.values().stream().toList();
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public void addProduct(Product product) {
        products.put(product.getPid(), product);
    }

    public void updateProduct(int id, Product product) {
        if (products.containsKey(id)) {
            products.put(id, product);
        }
    }

    public void deleteProduct(int id) {
        products.remove(id);
    }

    public void saveAll(List<Product> products) {
        for (Product product : products) {
            this.products.put(product.getPid(), product);
        }
    }

    public List<Product> getAll() {
        return products.values().stream().toList();
    }
}