package dev.jsoo.orderservice.service;

import dev.jsoo.orderservice.dto.OrderDto;
import dev.jsoo.orderservice.entity.OrderEntity;
import dev.jsoo.orderservice.mapStruct.OrderMapper;
import dev.jsoo.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQuantity() * orderDto.getPrice());
        OrderEntity orderEntity = OrderMapper.INSTANCE.dtoToEntity(orderDto);
        orderRepository.save(orderEntity);
        return orderDto;
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        return OrderMapper.INSTANCE.entityToDto(orderRepository.findByOrderId(orderId));
    }

    @Override
    public Iterable<OrderDto> getOrderByUserId(String userId) {
        return OrderMapper.INSTANCE.entityToDto(orderRepository.findByUserId(userId));
    }
}
