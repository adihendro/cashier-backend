package com.blibli.cashier.backend.controller.model.request;

import com.blibli.cashier.backend.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderRequest {
    private Customer customer;
    private List<OrderItemRequest> orderItems;
}
