package com.blibli.cashier.backend.controller;

import com.blibli.cashier.backend.controller.model.request.OrderRequest;
import com.blibli.cashier.backend.controller.model.response.OrderResponse;
import com.blibli.cashier.backend.entity.Order;
import com.blibli.cashier.backend.service.impl.CashierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private CashierServiceImpl cashierService;

    @GetMapping(value = "/orders")
    public OrderResponse getOrder (
        @RequestParam(required = false) boolean orderByCustomer,
        @RequestParam(required = false) boolean orderByPrice
    ) {
        return cashierService.getOrder(orderByCustomer, orderByPrice);
    }

    @GetMapping(value = "/orders/{orderId}")
    public Order getOrderById (
            @PathVariable int orderId){
        return cashierService.getOrderById(orderId);
    }


    @PostMapping(value = "/orders")
    public Order submitOrder (
            @RequestBody OrderRequest orderRequest) {
        return cashierService.insertOrder(orderRequest);
    }
}
