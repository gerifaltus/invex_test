package com.invex.backend.service;

import com.invex.backend.entity.CatalogItem;

public interface CatalogItemService {
    
    CatalogItem getByCode(String code);
    
}
