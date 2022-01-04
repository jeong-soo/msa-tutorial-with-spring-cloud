package dev.jsoo.orderservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {
    private String productId;
    private Integer quantity;
    private Integer price;
    private Integer totalPrice;
    private String orderId;

    private Date createAt;
}
