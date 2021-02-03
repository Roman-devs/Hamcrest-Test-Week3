package de.neuefische.studentdb.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private int id;
    private final List<Product> orderedProducts = new ArrayList<>();

    public Product addProduct(Product product) {
        orderedProducts.add(product);
        return product;
    }

    public  Product removeProduct(Product product) {
        orderedProducts.remove(product);
        return  product;
    }
}
