package com.blibli.cashier.backend.service.impl;

import com.blibli.cashier.backend.controller.model.request.OrderItemRequest;
import com.blibli.cashier.backend.controller.model.request.OrderRequest;
import com.blibli.cashier.backend.controller.model.response.OrderResponse;
import com.blibli.cashier.backend.entity.Customer;
import com.blibli.cashier.backend.entity.Order;
import com.blibli.cashier.backend.entity.OrderItem;
import com.blibli.cashier.backend.service.CashierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    private List<Order> orderItemLists = new ArrayList<>();
    private int orderId = 0;

    @Override
    public OrderResponse getOrder() {
//        return Order
//                .builder()
////                .orderItems(getOrderItems())
//                .totalPrice(2100)(
//                .customer(Customer.builder().build())
//                .build();
        return new OrderResponse(orderItemLists);
    }

    @Override
    public Order getOrderById(int id) {
        return orderItemLists.get(id);
    }

    @Override
    public Order insertOrder(OrderRequest orderRequest) {
        List<OrderItemRequest> orderItemRequests = orderRequest.getOrderItems();
        List<OrderItem> orderItems = new ArrayList<>();
        int orderItemId = 0;
        int totalPrice = 0;
        int tempPrice;
        for (OrderItemRequest orderItemRequest: orderItemRequests){
            tempPrice = orderItemRequest.getPrice() * orderItemRequest.getQuantity();
            totalPrice += tempPrice;
            orderItems.add(OrderItem.builder()
                    .price(tempPrice)
                    .quantity(orderItemRequest.getQuantity())
                    .productName(orderItemRequest.getProductName())
                    .id(orderItemId++)
                    .build());
        }

        Order order = Order.builder()
                .id(orderId++)
                .totalPrice(totalPrice)
                .customer(orderRequest.getCustomer())
                .orderItem(orderItems)
                .build();
        orderItemLists.add(order);
        return order;
    }
}
