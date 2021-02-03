package de.neuefische.studentdb.service;

import de.neuefische.studentdb.database.ProductDb;
import de.neuefische.studentdb.model.Product;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @Test
    void getProductListTest() {

        // Given
        Product firstProduct = new Product("12","Shampoo");
        Product secondProduct = new Product("13","Conditioner");

        ProductDb mockedDB = mock(ProductDb.class);
        when(mockedDB.getProductList()).thenReturn(List.of(
                firstProduct,
                secondProduct
        ));

        ProductService productServiceTest = new ProductService(mockedDB);
        List<Product> actual = productServiceTest.getProductList("Sh");
        // When
        List<Product> expected = new ArrayList<>();
        expected.add(firstProduct);
        // Then
        assertThat(actual, containsInAnyOrder(firstProduct));
    }

}