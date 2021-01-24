package com.blibli.cashier.backend.controller.model.request;

import com.blibli.cashier.backend.entity.Customer;
import com.blibli.cashier.backend.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Customer customer;
    private List<OrderItemRequest> orderItems;
}
