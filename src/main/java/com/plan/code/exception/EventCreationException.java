package com.plan.code.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EventCreationException thrown when request to create an event is a bad
 * request.
 * 
 * @author deepakedward
 *
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad Request sent")
public class EventCreationException extends Exception {

	private static final long serialVersionUID = 1L;

	public EventCreationException(String message) {
		super(message);
	}
}
