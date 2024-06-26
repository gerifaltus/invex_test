package com.invex.backend.service;

import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.invex.backend.dto.catalog.CatalogItemFieldDto;
import com.invex.backend.dto.employee.EmployeeGeneralDto;
import com.invex.backend.entity.CatalogItem;
import com.invex.backend.exceptions.BusinessException;
import com.invex.backend.repository.CatalogItemRepository;
import com.invex.backend.repository.EmployeeRepository;
import com.invex.backend.service.impl.CatalogItemServiceImpl;
import com.invex.backend.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    
    @Mock
    private EmployeeRepository employeeRepository;
    
    @Mock
    private CatalogItemRepository catalogItemRepository;
    
    @Mock
    private CatalogItemServiceImpl catalogItemServiceImpl; 
    
    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;
    
    @BeforeEach
    public void init() {
      MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void saveEmployeesTest() throws BusinessException {
        EmployeeGeneralDto employee1 = generateEmployees();
        List<EmployeeGeneralDto> listEmployee = new ArrayList<>();
        listEmployee.add(employee1);
        
        CatalogItem ci = generateCatalogItem();
        
        employeeServiceImpl.saveEmployee(listEmployee);
        
        //when(catalogItemRepository.getByCode(anyString())).thenReturn(ci);
        when(catalogItemServiceImpl.getByCode(anyString())).thenReturn(ci);
        verify(employeeRepository, times(1)).saveAll(anyIterable());
    }
    
    private EmployeeGeneralDto generateEmployees() {
        CatalogItemFieldDto ciGender = new CatalogItemFieldDto();
        ciGender.setCode("M");
        
        CatalogItemFieldDto ciPosition = new CatalogItemFieldDto();
        ciPosition.setCode("P001");
        
        EmployeeGeneralDto employee1 = new EmployeeGeneralDto();
        employee1.setActive(Boolean.TRUE);
        employee1.setAge(20);
        employee1.setBirthdate(LocalDate.now().minusYears(10));
        employee1.setFirstName("Juan");
        employee1.setGender(ciGender);
        employee1.setLastName("Perez");
        employee1.setMothersLastName("Jolote");
        employee1.setPosition(ciPosition);
        
        return employee1;
    }
    
    private CatalogItem generateCatalogItem() {
        CatalogItem ciGender = new CatalogItem();
        ciGender.setCode("M");
        
        return ciGender;
    }
}
