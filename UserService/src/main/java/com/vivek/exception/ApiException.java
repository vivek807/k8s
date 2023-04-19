package com.vivek.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.List;

@Getter
@ToString
public class ApiException extends  RuntimeException {
	@Serial
	private static final long serialVersionUID = 1;

	private final HttpStatus statusCode;
	private final List<?> params;


	public ApiException(String msg, HttpStatus statusCode, List<?> params) {
		super(msg);
		this.statusCode = statusCode;
		this.params = params;
	}

	public ApiException(String msg, HttpStatus statusCode) {
		super(msg);
		this.statusCode = statusCode;
		this.params = null;
	}

	public static <T> ApiException resourceNotFound(String name, T id) {
		return new ApiException("resource.not.found", HttpStatus.NOT_FOUND, List.of(name, id));
	}

	public static <T> ApiException resourceNotFound(T id) {
		return new ApiException("resource.not.found", HttpStatus.NOT_FOUND, List.of(id));
	}

	public static <T> ApiException invalidArgument(String name) {
		return new ApiException("resource.invalid", HttpStatus.BAD_REQUEST, List.of(name));
	}

	public static <T> ApiException alreadyExists(String name) {
		return new ApiException("resource.already.exists", HttpStatus.BAD_REQUEST, List.of(name));
	}
}
