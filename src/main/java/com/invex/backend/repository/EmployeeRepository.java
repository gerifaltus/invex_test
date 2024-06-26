package com.invex.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invex.backend.dto.employee.EmployeeListDto;
import com.invex.backend.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, RevisionRepository<Employee, Integer, Long>{
	
	@Query(""" 
            SELECT new com.invex.backend.dto.employee.EmployeeListDto( 
                e.id AS id, e.firstName AS firstName, e.secondName AS secondName, 
                e.lastName AS lastName, e.mothersLastName As mothersLastName,
                e.age AS age, cig.nameItem AS gender, e.birthdate AS birthdate,
                cip.nameItem AS position)
            FROM Employee e 
                INNER JOIN CatalogItem cig 
                    ON e.gender.id = cig.id
                INNER JOIN CatalogItem cip
                    ON e.position.id = cip.id
            WHERE e.active = true 
            """)
	List<EmployeeListDto> getAllEmployees();

	@Query(""" 
            SELECT e 
            FROM Employee e
            WHERE e.id = :id AND e.active = true 
            """)
    Employee getId(@Param("id") Integer id);

}
