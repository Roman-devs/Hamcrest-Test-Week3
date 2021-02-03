package de.neuefische.studentdb.controller;

import de.neuefische.studentdb.model.Order;
import de.neuefische.studentdb.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("order")
    public Optional<Order> orderProduct(@RequestParam Optional<String> productID) {
        Optional<Order> order =  orderService.addProductToOrder(productID.orElse(""));
        return  order;
    }

    @GetMapping("completeOrder")
    public Optional<Order> completeOrder() {
        return  orderService.completeOrder();
    }

    @GetMapping("allOrders")
    public List<Order> getOrderList() {
        return  orderService.getOrderList();
    }
}
