package dev.jsoo.userservice.mapStruct;

import dev.jsoo.userservice.dto.UserDto;
import dev.jsoo.userservice.jpa.UserEntity;
import dev.jsoo.userservice.vo.RequestUser;
import dev.jsoo.userservice.vo.ResponseUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(source = "encryptedPassword", target = "password")
    UserEntity dtoToEntity(UserDto dto);

    @Mapping(source = "password", target = "encryptedPassword")
    UserDto entityToDto(UserEntity entity);

    Iterable<UserDto> entityToDto(Iterable<UserEntity> entities);

    UserDto requestToDto(RequestUser request);

    ResponseUser dtoToResponse(UserDto dto);

    Iterable<ResponseUser> dtoToResponse(Iterable<UserDto> dtos);
}
