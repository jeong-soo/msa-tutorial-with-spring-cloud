package dev.jsoo.orderservice.service;

import dev.jsoo.orderservice.dto.OrderDto;
import dev.jsoo.orderservice.vo.ResponseOrder;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderByOrderId(String orderId);

    Iterable<OrderDto> getOrderByUserId(String userId);
}
