package dev.jsoo.catalogservice.service;

import dev.jsoo.catalogservice.dto.CatalogDto;
import dev.jsoo.catalogservice.entity.CatalogEntity;
import dev.jsoo.catalogservice.mapStruct.CatalogMapper;
import dev.jsoo.catalogservice.repository.CatalogRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {
    private CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
