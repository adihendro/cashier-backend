package com.blibli.cashier.backend.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {
    private int id;
    private String productName;
    private int price;
    private int quantity;
}
