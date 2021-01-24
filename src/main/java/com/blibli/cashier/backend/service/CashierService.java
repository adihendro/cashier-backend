package com.blibli.cashier.backend.service;

import com.blibli.cashier.backend.controller.request.OrderRequest;
import com.blibli.cashier.backend.entity.Order;

public interface CashierService {
    public Order getOrder();
    public Order insertOrder(OrderRequest orderRequest);
}
