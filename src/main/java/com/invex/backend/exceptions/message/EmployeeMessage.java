package com.invex.backend.exceptions.message;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeMessage implements BusinessError{

    EMPLOYEE_ID_NOT_FOUND("MSG_CODE_9000", "Empleado no encontrado", HttpStatus.NOT_FOUND),
    EMPLOYEE_SAVED_SUCCESSFULLY("MSG_CODE_9002", "Empleado(s) guardado(s) correctamente", HttpStatus.OK),
    EMPLOYEE_UPDATED_SUCCESSFULLY("MSG_CODE_9003", "Empleado(s) actualizado(s) correctamente", HttpStatus.OK),
    EMPLOYEE_MISSING_ID("MSG_CODE_9004", "Error al procesar la petición, identificador del Empleado no encontrado.", HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_FOUND("MSG_CODE_9005", "Error al procesar la petición, Empleado no encontrado.", HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_FOUND_GENDER("MSG_CODE_9006", "Error al procesar la petición, genero no encontrado.", HttpStatus.NOT_FOUND),
    EMPLOYEE_NOT_FOUND_POSITION("MSG_CODE_9007", "Error al procesar la petición, posición no encontrada.", HttpStatus.NOT_FOUND),
    EMPLOYEE_DELETED_SUCCESSFULLY("MSG_CODE_9008", "Empleado eliminado correctamente.", HttpStatus.OK),
    ;
    
    private String code;
    
    private String message;
    
    private HttpStatus status;
}
