package com.plan.code.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EventNotFoundException is thrown when the given event id is not found.
 * 
 * @author deepakedward
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Event Not Found")
public class EventNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EventNotFoundException(String message) {
		super(message);
	}

}
