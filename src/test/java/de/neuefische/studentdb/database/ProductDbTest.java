package de.neuefische.studentdb.database;

import de.neuefische.studentdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDbTest {

    @Test
    @DisplayName("List Product Test")
    void addProduct() {

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
    void addTwoProducts() {

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
    void getProductList() {
    }



    @Test
    void getProductByID() {
    }
}