package de.neuefische.studentdb.service;

import de.neuefische.studentdb.database.ProductDb;
import de.neuefische.studentdb.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductDb productDb;

    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }

    public List<Product> getProductList(String search){
        List<Product> result = new ArrayList<>();
        for (Product product : productDb.getProductList()) {
            if(product.getName().contains(search)){
                result.add(product);
            }
        } return result;
    }

    public  List<Product> getAllProductsList() {
        return  productDb.getProductList();
    }

    public  Product addProduct(Product product) {
        return  productDb.addProduct(product);
    }
}
