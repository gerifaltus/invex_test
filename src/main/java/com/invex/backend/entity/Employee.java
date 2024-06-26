package com.invex.backend.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Audited
@AuditTable(value = "au_employee")
@Getter
@Setter
@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 1708669090834870355L;

    @Version Long version;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="first_name", length = 30)
    private String firstName;
	
	@Column(name="second_name", length = 30)
    private String secondName;
	
	@Column(name="last_name", length = 30)
    private String lastName;
	
	@Column(name="mothers_last_name", length = 30)
	private String mothersLastName;
	
	@Column(name="age")
    private Integer age;
	
	@Column(name="active")
	private Boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_gender", nullable = false)
    private CatalogItem gender;
	
	@Column(name="birthdate")
    private LocalDate birthdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_position", nullable = false)
    private CatalogItem position;
	
	
}
