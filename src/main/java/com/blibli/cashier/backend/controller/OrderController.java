package com.blibli.cashier.backend.controller;

import com.blibli.cashier.backend.controller.request.OrderRequest;
import com.blibli.cashier.backend.controller.response.OrderResponse;
import com.blibli.cashier.backend.entity.Order;
import com.blibli.cashier.backend.service.implementation.CashierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private CashierServiceImpl cashierService;

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderResponse getOrder () {
        Order order = cashierService.getOrder();
        return OrderResponse
                .builder()
                .totalPrice(order.getTotalPrice())
                .customer(order.getCustomer())
                .orderItem(order.getOrderItem())
                .build();
    }

    @PostMapping(value = "/orders")
    public String submitOrder (
            @RequestBody OrderRequest orderRequest) {
        Order order = cashierService.insertOrder(orderRequest);
        return "success: true";
    }
}
