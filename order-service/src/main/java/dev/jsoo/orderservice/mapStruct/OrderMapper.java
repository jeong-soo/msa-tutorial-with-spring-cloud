package dev.jsoo.orderservice.mapStruct;

import dev.jsoo.orderservice.dto.OrderDto;
import dev.jsoo.orderservice.entity.OrderEntity;
import dev.jsoo.orderservice.vo.ResponseOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto entityToDto(OrderEntity entity);

    Iterable<OrderDto> entityToDto(Iterable<OrderEntity> entities);

    ResponseOrder entityToResponse(OrderEntity entity);

    Iterable<ResponseOrder> entityToResponse(Iterable<OrderEntity> entities);
}
