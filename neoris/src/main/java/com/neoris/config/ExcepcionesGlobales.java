package com.neoris.config;

import com.neoris.excepciones.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import com.neoris.excepciones.ErrorResponse;
import com.neoris.excepciones.NotFoundException;

@ControllerAdvice
@Slf4j
public class ExcepcionesGlobales {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> ApiException(NotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value()
		);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> ApiException(BadRequestException ex){
		ErrorResponse errorResponse = new ErrorResponse(
				ex.getMessage(),
				HttpStatus.BAD_REQUEST.value()
		);
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
