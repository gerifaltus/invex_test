package com.invex.backend.service.impl;

import org.springframework.stereotype.Service;

import com.invex.backend.entity.CatalogItem;
import com.invex.backend.repository.CatalogItemRepository;
import com.invex.backend.service.CatalogItemService;

@Service
public class CatalogItemServiceImpl implements CatalogItemService {

    private CatalogItemRepository catalogItemRepository;
    
    public CatalogItemServiceImpl(CatalogItemRepository catalogItemRepository) {
        this.catalogItemRepository = catalogItemRepository;
    }
    
    /**
     * Consulta y devuelve el catalogoItem indicado en el parametro
     * @param code Codigo del catálogo a consultar
     */
    @Override
    public CatalogItem getByCode(String code) {
        return catalogItemRepository.getByCode(code);
    }

}
