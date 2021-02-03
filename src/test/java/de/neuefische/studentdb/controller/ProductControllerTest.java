package de.neuefische.studentdb.controller;

import de.neuefische.studentdb.database.ProductDb;
import de.neuefische.studentdb.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Autowired
    private ProductDb productDb;

    @Test
    void getProductByNameTest() {
        // GIVEN
        String name = "Sh";
        String url = "http://localhost:" + port +"/products?name=" + name ;
        List<Product> productList = new ArrayList<>();
        Product product = new Product("11", "Shampoo");
        Product anotherProduct = new Product("12", "Deodorant");
        productDb.addProduct(product);
        productDb.addProduct(anotherProduct);

        // WHEN
        ResponseEntity<Product[]> response = testRestTemplate.getForEntity(url, Product[].class);


        // THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(new Product[] { new Product("11", "Shampoo")}));

    }

    @Test
    void addProductsTest() {

        // GIVEN
        String url = "http://localhost:" + port + "/products/multi";
        Product[] products = new Product[3];
        products[0] = new Product("1", "Shampoo");
        products[1] = new Product("2", "Lotion");
        products[2] = new Product("3", "Deodorant");

        List<Product> expected = new ArrayList<>();
        expected.add(new Product("1", "Shampoo"));
        expected.add(new Product("2", "Lotion"));
        expected.add(new Product("3", "Deodorant"));

        // WHEN
        ResponseEntity<Product[]> response = testRestTemplate.postForEntity(url, products, Product[].class);


        // THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), arrayContaining(
                new Product("1", "Shampoo"),
                new Product("2", "Lotion"),
                new Product("3", "Deodorant")));
    }


}