package com.invex.backend.service;

import java.util.List;

import com.invex.backend.dto.employee.EmployeeGeneralDto;
import com.invex.backend.dto.employee.EmployeeListDto;
import com.invex.backend.exceptions.BusinessException;

public interface EmployeeService {

	List<EmployeeListDto> getAllEmployee();
	
	void saveEmployee(List<EmployeeGeneralDto> listEmployeeDto) throws BusinessException;
	
	void updateEmployee(EmployeeGeneralDto employeeGeneralDto, Integer id) throws BusinessException;
	
	void deleteEmployee(Integer id) throws BusinessException;
}
