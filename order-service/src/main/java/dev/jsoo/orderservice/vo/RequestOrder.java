package dev.jsoo.orderservice.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestOrder {
    private String productId;
    private Integer quantity;
    private Integer price;
}
