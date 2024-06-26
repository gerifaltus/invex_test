package com.invex.backend.dto.employee;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeListDto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 746872426847279052L;

	private Integer id;
	
	private String firstName;
	
    private String secondName;
	
    private String lastName;
	
	private String mothersLastName;
	
    private Integer age;
	
    private String gender;
	
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    
    private String position;
}
