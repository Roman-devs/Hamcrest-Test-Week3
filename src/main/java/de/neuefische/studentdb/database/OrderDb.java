package de.neuefische.studentdb.database;

import de.neuefische.studentdb.model.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class OrderDb {

    private final HashMap<Integer,Order> registeredOrders = new HashMap<>();

    private  int nextOrderID = 1;

    public  List<Order> getOrders() {
        return  List.copyOf(registeredOrders.values());
    }

    public Order addOrder(Order order) {
        order.setId(nextOrderID);
        registeredOrders.put(nextOrderID, order);
        nextOrderID++;
        return  order;
    }
}
