package com.invex.backend.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="catalog_main")
public class CatalogMain {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id", nullable = false)
	private Integer id;
    
	@Column(name="code")
	private String code;
	
	@Column(name="name_item")
	private String nameItem;
	
	@Column(name="description")
	private String description;
	
	@Column(name="active")
	private Boolean active;
	
	@OneToMany(mappedBy = "catalogMain", fetch = FetchType.LAZY, 
			targetEntity = CatalogItem.class)
	@OrderBy("description ASC")
	private List<CatalogItem> listCatalogItems;
}
