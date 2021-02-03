package de.neuefische.studentdb.service;

import de.neuefische.studentdb.database.ProductDb;
import de.neuefische.studentdb.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {


    @Test
    void getProductListTest() {

        // Given
        ProductDb mockedDB = mock(ProductDb.class);

        Product firstProduct = new Product("12", "Shampoo");
        Product secondProduct = new Product("13", "Conditioner");

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

    @Test
    @DisplayName("Test add Product")
    void addProductTest() {

        // Given
        ProductDb mockedDB = mock(ProductDb.class);

        Product secondProduct = new Product("13", "Conditioner");

        when(mockedDB.addProduct(secondProduct)).thenReturn(secondProduct);
        ProductService productServiceTest = new ProductService(mockedDB);

        //When

        Product actual = productServiceTest.addProduct(secondProduct);

        //Then

        assertThat(actual, is(secondProduct));
        verify(mockedDB).addProduct(secondProduct);
    }


}