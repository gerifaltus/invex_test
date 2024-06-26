package com.invex.backend.exceptions;


import com.invex.backend.exceptions.message.BusinessError;
import com.invex.backend.exceptions.message.ErrorMessages;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6351692911493080751L;

	private BusinessError error;
	
	public BusinessException() {
		super(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage());
		this.setError(ErrorMessages.INTERNAL_SERVER_ERROR);
	}
	
	public BusinessException(final Throwable e) {
		super(e);
		this.setError(ErrorMessages.INTERNAL_SERVER_ERROR);
	}
	
	public BusinessException(final BusinessError businessError) {
		super(getBusinessMessage(businessError));
		if(businessError == null) {
			this.setError(ErrorMessages.INTERNAL_SERVER_ERROR);
		}else {
			this.setError(businessError);
		}
	}
	
	public BusinessException(final BusinessError businessError, final Throwable e) {
		super(e);
		if(businessError == null) {
			this.setError(ErrorMessages.INTERNAL_SERVER_ERROR);
		}else {
			this.setError(businessError);
		}
	}
	
	public BusinessException(final BusinessError businessError, final String message) {
		super(getBusinessMessage(businessError, message));
		if(businessError == null) {
			this.setError(ErrorMessages.INTERNAL_SERVER_ERROR);
		}else {
			this.setError(businessError);
		}
	}
	
	protected static String getBusinessMessage(final BusinessError businessError, final String message) {
		if(message != null && !message.trim().equals("")) {
			return message;
		}else {
			return getBusinessMessage(businessError);
		}
	}
	
	protected static String getBusinessMessage(final BusinessError businessError) {
		if(businessError == null) {
			return ErrorMessages.INTERNAL_SERVER_ERROR.getMessage();
		}else {
			return businessError.getMessage();
		}
	}

	public BusinessError getError() {
		return error;
	}

	public void setError(BusinessError error) {
		this.error = error;
	}

}
