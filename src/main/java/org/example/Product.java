package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String name;
    private int quantity;
    private double price;

    // No-arg constructor (required by JPA)
    public Product() {
    }

    // Constructor with all fields (except pid if you want)
    public Product(Integer pid, String name, int quantity, double price) {
        this.pid = pid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Or constructor without pid if pid is generated
    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setPname(String iPhone) {
        this.name = iPhone;
    }

    public void setQty(int i) {
        this.quantity = i;
    }

    public String getPname() {
        return name;
    }

    public int getQty() {
        return quantity;
    }


    // getters and setters...
}
