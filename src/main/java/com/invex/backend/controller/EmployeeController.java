package com.invex.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invex.backend.dto.employee.EmployeeGeneralDto;
import com.invex.backend.dto.employee.EmployeeListDto;
import com.invex.backend.exceptions.BusinessException;
import com.invex.backend.exceptions.message.EmployeeMessage;
import com.invex.backend.exceptions.message.ResponseDefault;
import com.invex.backend.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<ResponseDefault<String>> saveEmployee(
	        @RequestBody @Valid @NotEmpty List<EmployeeGeneralDto> listEmployeeDto) throws BusinessException {
		log.info("saveEmployee - Inicia guardado de employee");
		
		employeeService.saveEmployee(listEmployeeDto);
		
		ResponseDefault<String> responseDefault = new ResponseDefault<>(EmployeeMessage.EMPLOYEE_SAVED_SUCCESSFULLY);
		log.info("saveEmployee - Finaliza guardado de employee");
        return new ResponseEntity<>(responseDefault, EmployeeMessage.EMPLOYEE_SAVED_SUCCESSFULLY.getStatus());
    
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<ResponseDefault<String>> updateEmployee(
	        @RequestBody @Valid EmployeeGeneralDto employeeDto, 
	        @PathVariable @Valid @Positive @NotNull Integer id) throws BusinessException {
	    log.info("updateEmployee - Inicia update de employee");
	    
	    employeeService.updateEmployee(employeeDto, id);
	    
	    ResponseDefault<String> responseDefault = new ResponseDefault<>(EmployeeMessage.EMPLOYEE_UPDATED_SUCCESSFULLY);
        log.info("updateEmployee - Finaliza update de employee");
        return new ResponseEntity<>(responseDefault, EmployeeMessage.EMPLOYEE_UPDATED_SUCCESSFULLY.getStatus());
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeListDto>> getEmployees() {
	    log.info("getEmployees");
		List<EmployeeListDto> listDto = employeeService.getAllEmployee();
		return new ResponseEntity<>(listDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<ResponseDefault<String>> deleteEmployees(
	        @PathVariable @Valid @Positive @NotNull Integer id) throws BusinessException {
	    log.info("deleteEmployees - Inicia delete de employee");
	    employeeService.deleteEmployee(id);
	    ResponseDefault<String> responseDefault = new ResponseDefault<>(EmployeeMessage.EMPLOYEE_DELETED_SUCCESSFULLY);
	    log.info("deleteEmployees - Finaliza update de employee");
	    return new ResponseEntity<>(responseDefault, EmployeeMessage.EMPLOYEE_DELETED_SUCCESSFULLY.getStatus());
	}
	
}
