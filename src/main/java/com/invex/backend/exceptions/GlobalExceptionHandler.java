package com.invex.backend.exceptions;

import java.sql.SQLException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.invex.backend.exceptions.message.ErrorMessages;
import com.invex.backend.exceptions.message.ResponseError;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(SQLException.class)
	public final ResponseEntity<ResponseError> handleSqlException(
			final SQLException ex, final WebRequest request){
		log.warn(ex.toString(), ex);
		ResponseError response = new ResponseError(ErrorMessages.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(response, ErrorMessages.INTERNAL_SERVER_ERROR.getStatus());
	}
	
	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<ResponseError> handleBusinessException(
			final BusinessException ex, final WebRequest request){
		log.warn(ex.toString(), ex);
		ResponseError response = new ResponseError(ex.getError());
		return new ResponseEntity<>(response, ex.getError().getStatus());
	}
	
}