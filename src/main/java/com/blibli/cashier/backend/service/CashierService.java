package com.blibli.cashier.backend.service;

import com.blibli.cashier.backend.controller.model.request.OrderRequest;
import com.blibli.cashier.backend.controller.model.response.OrderResponse;
import com.blibli.cashier.backend.entity.Order;

public interface CashierService {
    public OrderResponse getOrder(boolean orderByCustomer, boolean orderByPrice);
    public Order getOrderById(int orderId);
    public Order insertOrder(OrderRequest orderRequest);
}
