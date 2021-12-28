package dev.jsoo.userservice.mapStruct;

import dev.jsoo.userservice.dto.UserDto;
import dev.jsoo.userservice.jpa.UserEntity;
import dev.jsoo.userservice.vo.RequestUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(source = "encryptedPwd", target = "pwd")
    UserEntity dtoToEntity(UserDto dto);

    UserDto requestToDto(RequestUser request);
}
