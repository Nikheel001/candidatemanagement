package com.abk.candidatemanagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/**
 * 
 */
@ControllerAdvice
public class CandidateManagementExceptionHandler {

	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<ErrorDetail> handleResourceNotFound(ResourceNotFoundException exception,
			WebRequest webRequest) {
		ErrorDetail err = new ErrorDetail(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false),
				HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ NoResourceFoundException.class })
	public ResponseEntity<ErrorDetail> handleResourceNotFound(NoResourceFoundException exception,
			WebRequest webRequest) {
		ErrorDetail err = new ErrorDetail(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false),
				HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class })
	public ResponseEntity<ErrorDetail> handleResourceNotFound(WebRequest webRequest) {
		ErrorDetail err = new ErrorDetail(LocalDateTime.now(),
				"Validation failed for request please check request arguments", webRequest.getDescription(false),
				HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
}
