package com.blibli.cashier.backend.controller.model.response;

import com.blibli.cashier.backend.entity.Customer;
import com.blibli.cashier.backend.entity.Order;
import com.blibli.cashier.backend.entity.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private List<Order> orders;
}
