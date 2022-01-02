package dev.jsoo.catalogservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CatalogDto {
    private String productId;
    private Integer quantity;
    private Integer price;
    private Integer totalPrice;
    private String orderId;
    private String userId;
}
