package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductInitializer {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        Product product = new Product();
        product.setPname("iPhone");
        product.setQty(10);
        product.setPrice(999.99);
        productRepository.save(product);
    }
}
