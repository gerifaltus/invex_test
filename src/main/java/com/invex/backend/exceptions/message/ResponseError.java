package com.invex.backend.exceptions.message;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize
@JsonInclude(Include.NON_NULL)
public class ResponseError {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String code;
	private String message;
	private String errors;
	private Status status = Status.ERROR;
	
	public ResponseError() {
		this.timestamp = LocalDateTime.now();
	}
	
	public ResponseError(String code, String message) {
		this.code = code;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
	
	public ResponseError(BusinessError businessError) {
		this.code = businessError.getCode();
		this.message = businessError.getMessage();
		this.timestamp = LocalDateTime.now();
	}
	
	public ResponseError(BusinessError businessError, String errors) {
		this.code = businessError.getCode();
		this.message = businessError.getMessage();
		this.errors = errors;
		this.timestamp = LocalDateTime.now();
	}
	
	public enum Status{
		OK, ERROR,
	}
	
}
