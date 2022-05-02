package pl.sdacademy.springdemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pl.sdacademy.springdemo.model.Error;

@RestControllerAdvice
public class MyErrorAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(MyErrorAdvice.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Error handleException(HttpMessageNotReadableException exception) {
		LOG.error("exception message {}" , exception.getMessage());
		return new Error(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	}
}
