package com.blibli.cashier.backend.controller.request;

import com.blibli.cashier.backend.entity.Customer;
import com.blibli.cashier.backend.entity.OrderItem;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {
    private int id;
    private int totalPrice;
    private Customer customer;
    private OrderItem[] orderItem;
}
