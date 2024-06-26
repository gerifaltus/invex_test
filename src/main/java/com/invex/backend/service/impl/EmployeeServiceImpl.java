package com.invex.backend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.invex.backend.dto.employee.EmployeeGeneralDto;
import com.invex.backend.dto.employee.EmployeeListDto;
import com.invex.backend.entity.CatalogItem;
import com.invex.backend.entity.Employee;
import com.invex.backend.exceptions.BusinessException;
import com.invex.backend.exceptions.message.EmployeeMessage;
import com.invex.backend.repository.EmployeeRepository;
import com.invex.backend.service.CatalogItemService;
import com.invex.backend.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	private CatalogItemService catalogItemService;
	
	public EmployeeServiceImpl(
	        EmployeeRepository employeeRepository,
	        CatalogItemService catalogItemService) {
		this.employeeRepository = employeeRepository;
		this.catalogItemService = catalogItemService;
	}

	/**
	 * Devuelve la lista de los empleados activos
	 * @return List<EmployeeListDto>
	 */
	@Override
	public List<EmployeeListDto> getAllEmployee() {
		return this.employeeRepository.getAllEmployees();
	}

    /**
     * Procesa la lista de empleados que viene del controller
     * @param Lista de empleados a guardar
     */
	@Override
	public void saveEmployee(List<EmployeeGeneralDto> listEmployeeDto) throws BusinessException {
	    log.info("saveEmployee");
	    List<Employee> listEmployee = new ArrayList<>();
	    
	    for(EmployeeGeneralDto employeeDto : listEmployeeDto) {
	        Employee employee = new Employee();
	        this.validateCatalogItem(employeeDto, employee);
	        this.fillDataEmployee(employee, employeeDto);
	        listEmployee.add(employee);
	    }
	    
	    this.employeeRepository.saveAll(listEmployee);
	}

	/**
	 * Procesa la actualización del empleado indicado por el id
	 * @param employeeGeneralDto Datos del empleado a actualizar
	 * @param id id del empleado a actualizar
	 */
	@Override
	public void updateEmployee(EmployeeGeneralDto employeeGeneralDto, Integer id) throws BusinessException {
	    log.info("updateEmployee");
	    if(Objects.isNull(id)) {
	        throw new BusinessException(EmployeeMessage.EMPLOYEE_MISSING_ID);
	    }
	    
	    Employee employee = this.employeeRepository.getId(id);
	    
	    if(Objects.isNull(employee)) {
	        throw new BusinessException(EmployeeMessage.EMPLOYEE_NOT_FOUND);
	    }
	    
	    this.validateCatalogItem(employeeGeneralDto, employee);
	    this.fillDataEmployee(employee, employeeGeneralDto);
	    this.employeeRepository.save(employee);
        
	}

	/**
	 * Procesa la eliminación del empleado. Se realiza eliminación lógica con el campo active
	 * @param id Id del empleado a eliminar. 
	 */
	@Override
	public void deleteEmployee(Integer id) throws BusinessException {
	    log.info("deleteEmployee");
	    if(Objects.isNull(id)) {
            throw new BusinessException(EmployeeMessage.EMPLOYEE_MISSING_ID);
        }
        
        Employee employee = this.employeeRepository.getId(id);
        
        if(Objects.isNull(employee)) {
            throw new BusinessException(EmployeeMessage.EMPLOYEE_NOT_FOUND);
        }
        
        employee.setActive(Boolean.FALSE);
        this.employeeRepository.save(employee);
	}
	
	/**
	 * Valida que gender y position existan en la bd, después se asignan al objeto empleado
	 * @param employeeDto
	 * @param employee
	 * @throws BusinessException
	 */
	private void validateCatalogItem(EmployeeGeneralDto employeeDto, Employee employee) throws BusinessException {
	    CatalogItem gender = this.catalogItemService.getByCode(employeeDto.getGender().getCode());
	    CatalogItem position = this.catalogItemService.getByCode(employeeDto.getPosition().getCode());
	    
	    if(Objects.isNull(gender)) {
	        throw new BusinessException(EmployeeMessage.EMPLOYEE_NOT_FOUND_GENDER);
	    }
	    
	    if(Objects.isNull(position)) {
            throw new BusinessException(EmployeeMessage.EMPLOYEE_NOT_FOUND_POSITION);
        }
	    
	    employee.setGender(gender);
	    employee.setPosition(position);
	}
	
	/**
	 * Realiza el seteo de las propiedades desde el dto hacia el objeto employee
	 * @param employee
	 * @param employeeDto
	 */
	private void fillDataEmployee(Employee employee, EmployeeGeneralDto employeeDto) {
	    employee.setActive(employeeDto.getActive());
	    employee.setAge(employeeDto.getAge());
	    employee.setBirthdate(employeeDto.getBirthdate());
	    employee.setFirstName(employeeDto.getFirstName());
	    employee.setLastName(employeeDto.getLastName());
	    employee.setMothersLastName(employeeDto.getMothersLastName());
	    employee.setSecondName(employeeDto.getSecondName());
	}

}
