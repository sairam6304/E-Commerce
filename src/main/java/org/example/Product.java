package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer pid;

    private String name;

    private double price;

    private int quantity;

    public Product() {
    }

    public Product(Integer pid, String name, double price, int quantity) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // equals, hashCode, toString if needed
}
