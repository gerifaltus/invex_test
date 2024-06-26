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
public class ResponseDefault<T> {

    private Status status = Status.OK;
    private String message;
    private T data;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String code;
    
    public ResponseDefault() {
        this.status = Status.OK;
        this.timestamp = LocalDateTime.now();
    }
    
    public ResponseDefault(final T data) {
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
    
    public ResponseDefault(final Status status, final String message, 
            final T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
    
    public ResponseDefault(BusinessError businessError) {
        this.code = businessError.getCode();
        this.message = businessError.getMessage();
        this.timestamp = LocalDateTime.now();
    }
    
    public enum Status{
        OK, ERROR,
    }
    
}