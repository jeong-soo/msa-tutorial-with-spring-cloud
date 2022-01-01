package dev.jsoo.userservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class ResponseOrder {
    private String productId;
    private Integer quantity;
    private Integer price;
    private Integer totalPrice;
    private Date createAt;

    private String orderId;
}
