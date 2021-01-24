package com.blibli.cashier.backend.controller.model.response;

import com.blibli.cashier.backend.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class OrderResponse {
    private List<Order> orders;
}
