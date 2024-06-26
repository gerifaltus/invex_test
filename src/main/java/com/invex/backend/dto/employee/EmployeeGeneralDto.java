package com.invex.backend.dto.employee;

import java.time.LocalDate;

import com.invex.backend.dto.catalog.CatalogItemFieldDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGeneralDto {

    @NotBlank
    private String firstName;
    
    private String secondName;
    
    @NotBlank
    private String lastName;
    
    private String mothersLastName;
    
    @NotNull
    @Positive
    private Integer age;
    
    @NotNull
    private CatalogItemFieldDto gender;
    
    @Past
    @NotNull
    private LocalDate birthdate;
    
    private Boolean active;
    
    @NotNull
    private CatalogItemFieldDto position;
    
}
