package com.datn.qltccn.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalException {

	private Logger logger = LoggerFactory.getLogger(GlobalException.class);
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception ex) {
	        if(ex instanceof ResultException) {
	            ErrorCode errorCode = ((ResultException) ex).getErrorCode();
	            switch (errorCode){
	                case RECORD_NOT_FOUND:
	                case RECORD_NOT_EXISTED:
					case FORBIDDEN:
					case FILE_UPLOAD_FAILED:
					case USER_DOES_NOT_EXIST:
	                    return new ResponseEntity<>(getErrorDetails(errorCode), HttpStatus.NOT_FOUND);
	                case RECORD_EXISTED:
					case EMAIL_EXISTED:
					case PASSWORD_MATCH:
	                    return new ResponseEntity<>(getErrorDetails(errorCode), HttpStatus.CONFLICT);
	                default:
	                    return new ResponseEntity<>(getErrorDetails(errorCode), HttpStatus.INTERNAL_SERVER_ERROR);

	            }
	        }
	        logger.error(ex.getMessage(), ex);
	        return new ResponseEntity<>(getErrorDetails(ErrorCode.INTER_SERVER), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    private ErrorDetails getErrorDetails(ErrorCode errorCode){
	        return new ErrorDetails(new Date(), errorCode.getCode(), errorCode.getMessage());
	    }
	
	
	
}
