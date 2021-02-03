package de.neuefische.studentdb.database;

import de.neuefische.studentdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductDbTest {

    @Test
    @DisplayName("List Product Test")
    void addProductandList() {

        // Given
        Product testProduct = new Product("1","Blutwurst");
        ProductDb testProductDb = new ProductDb();
        List<Product> expected = new ArrayList<>();
        expected.add(testProduct);
        // When
        testProductDb.addProduct(testProduct);
        // Then
        List<Product> actual = testProductDb.getProductList();

        assertEquals(actual, expected);

    }

    @Test
    @DisplayName("List Two Product Test")
    void addTwoProductsandList() {

        // Given
        Product testProduct = new Product("1","Blutwurst");
        Product anotherTestProduct = new Product("2","Leberwurst");
        ProductDb testProductDb = new ProductDb();
        List<Product> expected = new ArrayList<>();
        expected.add(testProduct);
        expected.add(anotherTestProduct);
        // When
        testProductDb.addProduct(testProduct);
        testProductDb.addProduct(anotherTestProduct);
        // Then
        List<Product> actual = testProductDb.getProductList();

        assertEquals(actual, expected);

    }


    //
    //
    //



    @Test
    @DisplayName("Get Product ID")
    void getProductByID() {


        //Given
        ProductDb productDb = new ProductDb();
        productDb.addProduct(new Product("11", "Tofu"));
        productDb.addProduct(new Product("13", "Potato"));


        //When
        Optional<Product> productOptional = productDb.getProductByID("11");


        //Then
        assertThat(productOptional.get(), is(new Product("11", "Tofu")));

    }



    @Test
    @DisplayName("Get Product ID non existent")
    void getProductByIDNonExistent() {


        //Given
        ProductDb productDb = new ProductDb();
        productDb.addProduct(new Product("11", "Tofu"));
        productDb.addProduct(new Product("13", "Potato"));


        //When
        Optional<Product> productOptional = productDb.getProductByID("22");


        //Then
        assertTrue(productOptional.isEmpty());

    }


}