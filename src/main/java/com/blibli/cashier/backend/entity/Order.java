package com.blibli.cashier.backend.entity;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Order {
    private int orderId;
    private List<OrderItem> orderItem;
    private int totalPrice;
    private Customer customer;

}
