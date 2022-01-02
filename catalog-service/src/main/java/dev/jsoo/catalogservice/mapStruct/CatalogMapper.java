package dev.jsoo.catalogservice.mapStruct;

import dev.jsoo.catalogservice.dto.CatalogDto;
import dev.jsoo.catalogservice.entity.CatalogEntity;
import dev.jsoo.catalogservice.vo.ResponseCatalog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    CatalogDto entityToDto(CatalogEntity entity);

    Iterable<CatalogDto> entityToDto(Iterable<CatalogEntity> entities);

    ResponseCatalog entityToResponse(CatalogEntity entity);

    Iterable<ResponseCatalog> entityToResponse(Iterable<CatalogEntity> entities);
}
