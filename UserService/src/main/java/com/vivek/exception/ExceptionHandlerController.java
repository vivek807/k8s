package com.vivek.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Hidden
@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ExceptionHandlerController {
	private final MessageSource messageSource;

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiError handleException(Throwable exception) {
		log.info(exception.getMessage());
		log.debug(exception.getMessage(), exception);
		return this.createException("internal.service.error", null, exception);
	}

	@ExceptionHandler
	public ResponseEntity<ApiError> handleException(ApiException error) {
		log.info(error.getMessage());
		log.debug(error.getMessage(), error);
		return new ResponseEntity<>(this.createException(error), error.getStatusCode());
	}

	private ApiError createException(final ApiException error) {
		return this.createException(error.getMessage(), error.getParams(), error);
	}

	private ApiError createException(String msgId, List<?> params, final Throwable error) {
		return this.createException(msgId, this.getMessage(msgId, error.getMessage(), params), params);
	}

	private ApiError createException(String msgId, String reason, List<?> params) {
		final ApiError apiError = new ApiError();

		apiError.setId(msgId);
		apiError.setMessage(reason);
		apiError.setParams(params);

		return apiError;
	}

	private String getMessage(String msgId, String defaultMessage, List<?> params) {
		return this.messageSource.getMessage(msgId, params != null ? params.toArray() : null, defaultMessage, LocaleContextHolder.getLocale());
	}
}
