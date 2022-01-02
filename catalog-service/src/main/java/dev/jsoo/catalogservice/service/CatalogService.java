package dev.jsoo.catalogservice.service;

import dev.jsoo.catalogservice.dto.CatalogDto;
import dev.jsoo.catalogservice.entity.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
