package com.bookstore.model;

import com.bookstore.util.RandomGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private String image;
    private int bucketId;

    public Product(String name, String description, double price, String image, int bucketId) {
        this.id = RandomGenerator.getRandomID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.bucketId = bucketId;
    }
}
