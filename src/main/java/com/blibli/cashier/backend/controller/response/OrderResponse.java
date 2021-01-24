package com.blibli.cashier.backend.controller.response;

import com.blibli.cashier.backend.entity.Customer;
import com.blibli.cashier.backend.entity.OrderItem;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
    private int id;
    private OrderItem[] orderItem;
    private double totalPrice;
    private Customer customer;
}
