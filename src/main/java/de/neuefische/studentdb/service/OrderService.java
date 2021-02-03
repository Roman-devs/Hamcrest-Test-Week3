package de.neuefische.studentdb.service;

import de.neuefische.studentdb.database.OrderDb;
import de.neuefische.studentdb.database.ProductDb;
import de.neuefische.studentdb.model.Order;
import de.neuefische.studentdb.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderDb orderDb;
    private ProductDb productDb;

    private Order currentOrder;

    public OrderService(OrderDb orderDb, ProductDb productDb) {
        this.orderDb = orderDb;
        this.productDb = productDb;
    }

    public Optional<Order> addProductToOrder(String productID) {
        Optional<Product> orderedProduct = productDb.getProductByID(productID);

        if (orderedProduct.isPresent()) {
            if (currentOrder == null) {
                currentOrder = new Order();
                orderDb.addOrder(currentOrder);
            }
            currentOrder.addProduct(orderedProduct.get());
            return Optional.of(currentOrder);
        }
        return  Optional.empty();
    }

    public  Optional<Order> removeProductFromOrder(Product product) {
        if(currentOrder == null)
            return  Optional.empty();

        currentOrder.removeProduct(product);

        return  Optional.of(currentOrder);
    }

    public  Optional<Order> completeOrder() {
        Optional<Order> result = Optional.empty();
        if(currentOrder != null)
            result = Optional.of(currentOrder);

        currentOrder = null;
        return  result;
    }

    public List<Order> getOrderList() {
        return  orderDb.getOrders();
    }
}
