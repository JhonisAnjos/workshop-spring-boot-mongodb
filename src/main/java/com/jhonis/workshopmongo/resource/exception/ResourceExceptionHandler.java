package com.jhonis.workshopmongo.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jhonis.workshopmongo.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		StandardError error = StandardError.builder().timestamp(System.currentTimeMillis()).status(HttpStatus.NOT_FOUND.value()).message("Não encontrado!")
				.error(exception.getMessage()).path(request.getRequestURI()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
