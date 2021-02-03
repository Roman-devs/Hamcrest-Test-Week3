package de.neuefische.studentdb.controller;

import de.neuefische.studentdb.database.ProductDb;
import de.neuefische.studentdb.model.Product;
import de.neuefische.studentdb.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProductByName( @RequestParam Optional<String> name){
        return productService.getProductList(name.orElse(""));
    }

    @GetMapping("all")
    public List<Product> getAllProducts() {
        return  productService.getAllProductsList();
    }

    @PutMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping ("multi")
    public List<Product> addProducts(@RequestBody Product[] products) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            result.add(productService.addProduct(product));
        }
        return result;
    }
}
