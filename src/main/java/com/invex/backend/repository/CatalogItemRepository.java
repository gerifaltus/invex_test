package com.invex.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invex.backend.entity.CatalogItem;

@Repository
public interface CatalogItemRepository extends JpaRepository<CatalogItem, Integer>{

    @Query(""" 
            SELECT ci 
            FROM CatalogItem ci 
            WHERE ci.active = true AND ci.code = :code 
           """)
    CatalogItem getByCode(@Param("code") String code);
    
}
