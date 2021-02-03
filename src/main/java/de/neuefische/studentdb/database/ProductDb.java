package de.neuefische.studentdb.database;

import de.neuefische.studentdb.model.Product;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDb {

    HashMap<String, Product> productHashMap = new HashMap<>();

    public List<Product> getProductList() {
        return List.copyOf(productHashMap.values());
    }

    public Product addProduct(Product product) {
        productHashMap.put(product.getId(), product);
        return product;
    }

    public Optional<Product> getProductByID(String id) {
        if(productHashMap.containsKey(id)) {
            return Optional.of( productHashMap.get(id));
        }
        return  Optional.empty();
    }
}
