package com.invex.backend.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Data
@Entity
@Table(name="catalog_item")
public class CatalogItem implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 4683217181581753860L;

    @Version Long version;
    
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
	
	@ManyToOne(targetEntity = CatalogMain.class, fetch = FetchType.LAZY)
	@JoinColumn(name="id_catalog_main")
	private CatalogMain catalogMain;
	
	@OneToMany(mappedBy = "gender", fetch = FetchType.LAZY, 
			targetEntity = Employee.class)
	private List<Employee> listEmployee;
	
}
