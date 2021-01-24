package com.blibli.cashier.backend.service.impl;

import com.blibli.cashier.backend.controller.model.request.OrderItemRequest;
import com.blibli.cashier.backend.controller.model.request.OrderRequest;
import com.blibli.cashier.backend.controller.model.response.OrderResponse;
import com.blibli.cashier.backend.entity.Order;
import com.blibli.cashier.backend.entity.OrderItem;
import com.blibli.cashier.backend.service.CashierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    private List<Order> orderItemLists = new ArrayList<>();
    private int orderId = 0;

    @Override
    public OrderResponse getOrder(boolean orderByCustomer, boolean orderByPrice) {
        List<Order> sortedOrderItemLists = new ArrayList<>(orderItemLists);

        if(orderByCustomer){
            sortedOrderItemLists.sort(Comparator.comparing(a -> a.getCustomer().getName()));
        } else if(orderByPrice){
            sortedOrderItemLists.sort((a,b) -> b.getTotalPrice() - a.getTotalPrice());
        }
        return new OrderResponse(sortedOrderItemLists);
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        try {
            order = orderItemLists.get(orderId);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order insertOrder(OrderRequest orderRequest) {
        List<OrderItem> orderItems = new ArrayList<>();
        int orderItemId = 0;
        int totalPrice = 0;
        for (OrderItemRequest orderItemRequest: orderRequest.getOrderItems()){
            totalPrice += orderItemRequest.getPrice() * orderItemRequest.getQuantity();;
            orderItems.add(OrderItem.builder()
                    .price(orderItemRequest.getPrice())
                    .quantity(orderItemRequest.getQuantity())
                    .productName(orderItemRequest.getProductName())
                    .orderItemId(orderItemId++)
                    .build());
        }

        Order order = Order.builder()
                .orderId(orderId++)
                .totalPrice(totalPrice)
                .customer(orderRequest.getCustomer())
                .orderItem(orderItems)
                .build();
        orderItemLists.add(order);
        return order;
    }
}
