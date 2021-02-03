package de.neuefische.studentdb.database;

import de.neuefische.studentdb.model.Order;
import de.neuefische.studentdb.model.Product;
import de.neuefische.studentdb.service.OrderService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDbTest {

    @Test
    void getOrdersTest() {

        // GIVEN
        OrderDb orderDB = new OrderDb();

        Product newProduct = new Product("11", "Tofu");
        Product anotherNewProduct = new Product("13", "Potato");

        Order order = new Order();
        order.addProduct(newProduct);
        order.addProduct(anotherNewProduct);

        orderDB.addOrder(order);

        List<Order> expectedList = new ArrayList<>();
        expectedList.add(order);


        // WHEN

        List<Order> actual = orderDB.getOrders();


        // THEN

        assertEquals(actual, expectedList);
    }

}