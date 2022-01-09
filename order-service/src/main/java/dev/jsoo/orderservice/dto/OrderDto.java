package dev.jsoo.orderservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDto {
    private String productId;
    private Integer quantity;
    private Integer price;
    private Integer totalPrice;
    private String orderId;
    private String userId;
}
