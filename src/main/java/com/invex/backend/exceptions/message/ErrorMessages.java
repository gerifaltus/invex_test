package com.invex.backend.exceptions.message;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessages implements BusinessError{
	
    INTERNAL_SERVER_ERROR("MSG_CODE_5000", "Error interno del servicio, intenta de nuevo o contacta a soporte", HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_FIELDS_FAIL("MSG_CODE_5001", "Error al validar la información.", HttpStatus.BAD_REQUEST)
	;
	
    
	private String code;
	
	private String message;
	
	private HttpStatus status;
/*
    @Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public HttpStatus getStatus() {
		return this.status;
	}
*/

}