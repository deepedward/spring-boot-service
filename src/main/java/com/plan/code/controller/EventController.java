package com.plan.code.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.plan.code.bean.Event;
import com.plan.code.exception.EventCreationException;
import com.plan.code.exception.EventNotFoundException;
import com.plan.code.service.EventService;

/**
 * Event Controller to expose the Rest APIs to create and fech events.
 * 
 * @author deepakedward
 *
 */
@RestController
@RequestMapping("/api")
public class EventController {
	private static final Logger logger = LogManager.getLogger(EventController.class);

	@Autowired
	private EventService eventService;

	/**
	 * The createEvent API creates an event if it does not exist.
	 * 
	 * @param event Event
	 * @return response EventResponse
	 */
	@RequestMapping(value = "/v1/events", method = RequestMethod.POST)
	@ResponseBody
	public Event createEvent(@RequestBody Event event) {
		logger.info("EventController: createEvent " + event);
		try {
			Event response = eventService.createEvent(event);
			return response;
		} catch (EventCreationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating event ", e);
		}
	}

	/**
	 * The event end point fetches an event by event id.
	 * 
	 * @param event String
	 * @return response EventResponse, response messages set in the method, can be
	 *         extracted to a properties file for better maintenance.
	 */
	@RequestMapping(value = "/v1/events/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Event fetchEvent(@PathVariable("id") int id) {
		logger.info("EventController: fetchEvent " + id);
		try {
			Event response = eventService.fetchEvent(id);
			return response;
		} catch (EventNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with id " + id + " not found", e);
		}
	}
}
