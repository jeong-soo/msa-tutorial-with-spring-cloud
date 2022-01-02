package dev.jsoo.catalogservice.controller;

import dev.jsoo.catalogservice.mapStruct.CatalogMapper;
import dev.jsoo.catalogservice.service.CatalogService;
import dev.jsoo.catalogservice.vo.ResponseCatalog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class CatalogController {
    private Environment env;
    private CatalogService catalogService;

    @Autowired
    public CatalogController(Environment env, CatalogService catalogService) {
        this.env = env;
        this.catalogService = catalogService;
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "It's Working in Catalog Service";
    }

    @GetMapping("/catalogs")
    public ResponseEntity<Iterable<ResponseCatalog>> getCatalog() {
        return ResponseEntity.status(HttpStatus.OK).body(CatalogMapper.INSTANCE.entityToResponse(catalogService.getAllCatalogs()));
    }
}
