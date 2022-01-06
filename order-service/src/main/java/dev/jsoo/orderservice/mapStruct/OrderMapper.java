package dev.jsoo.orderservice.mapStruct;

import dev.jsoo.orderservice.dto.OrderDto;
import dev.jsoo.orderservice.entity.OrderEntity;
import dev.jsoo.orderservice.vo.RequestOrder;
import dev.jsoo.orderservice.vo.ResponseOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto entityToDto(OrderEntity entity);

    Iterable<OrderDto> entityToDto(Iterable<OrderEntity> entities);

    OrderEntity dtoToEntity(OrderDto dto);

    ResponseOrder dtoToResponse(OrderDto dto);

    Iterable<ResponseOrder> dtoToResponse(Iterable<OrderDto> dtos);

    OrderDto requestToDto(RequestOrder request);
}
