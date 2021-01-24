package com.blibli.cashier.backend.controller.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemRequest {
    private String productName;
    private int price;
    private int quantity;
}
