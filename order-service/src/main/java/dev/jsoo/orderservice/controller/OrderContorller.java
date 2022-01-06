package dev.jsoo.orderservice.controller;

import dev.jsoo.orderservice.dto.OrderDto;
import dev.jsoo.orderservice.mapStruct.OrderMapper;
import dev.jsoo.orderservice.service.OrderService;
import dev.jsoo.orderservice.vo.RequestOrder;
import dev.jsoo.orderservice.vo.ResponseOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/")
public class OrderContorller {
    private Environment env;
    private OrderService orderService;

    @Autowired
    public OrderContorller(Environment env, OrderService orderService) {
        this.env = env;
        this.orderService = orderService;
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "It's Working in Order Service";
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<Iterable<ResponseOrder>> getOrder(@PathVariable("userId") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(OrderMapper.INSTANCE.dtoToResponse(orderService.getOrderByUserId(userId)));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable("userId") String userId, @RequestBody RequestOrder requestOrder){
        OrderDto orderDto = OrderMapper.INSTANCE.requestToDto(requestOrder);
        orderDto.setUserId(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(OrderMapper.INSTANCE.dtoToResponse(orderService.createOrder(orderDto)));
    }

}
