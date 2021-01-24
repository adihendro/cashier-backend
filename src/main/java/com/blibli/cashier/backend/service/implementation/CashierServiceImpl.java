package com.blibli.cashier.backend.service.implementation;

import com.blibli.cashier.backend.controller.request.OrderRequest;
import com.blibli.cashier.backend.entity.Customer;
import com.blibli.cashier.backend.entity.Order;
import com.blibli.cashier.backend.entity.OrderItem;
import com.blibli.cashier.backend.service.CashierService;
import org.springframework.stereotype.Service;

@Service
public class CashierServiceImpl implements CashierService {

    private String name;
    private int id = 0;

    @Override
    public Order getOrder() {
        return Order
                .builder()
//                .orderItems(getOrderItems())
                .totalPrice(2100)
                .customer(Customer.builder().build())
                .build();
    }

    @Override
    public Order insertOrder(OrderRequest orderRequest) {
        return Order
                .builder()
                .id(id++)
                .totalPrice(orderRequest.getTotalPrice())
                .customer(orderRequest.getCustomer())
                .orderItem(orderRequest.getOrderItem())
                .build();
    }
}
