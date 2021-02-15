package com.plan.code.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plan.code.bean.Event;
import com.plan.code.exception.EventCreationException;
import com.plan.code.exception.EventNotFoundException;
import com.plan.code.repository.EventRepository;

/**
 * Service to process request from the controller and connect to the repository
 * to perform CRUD operations.
 * 
 * @author deepakedward
 *
 */
@Service
public class EventService {
	private static final Logger logger = LogManager.getLogger(EventService.class);

	@Autowired
	private EventRepository eventRepository;

	/**
	 * Fetches an even by eventId.
	 * 
	 * @param eventId int
	 * @return event Event
	 * @throws EventNotFoundException
	 */
	public Event fetchEvent(long eventId) throws EventNotFoundException {
		logger.info("EventService: fetchEvent " + eventId);
		Optional<Event> eventResponse = eventRepository.findById(eventId);

		if (!eventResponse.isPresent()) {
			throw new EventNotFoundException("Event with id " + eventId + " not found.");
		}
		Event event = eventResponse.get();
		return event;
	}

	/**
	 * Creates a new event.
	 * 
	 * @param event
	 * @return eventResponse Event
	 * @throws EventCreationException
	 */
	public Event createEvent(Event event) throws EventCreationException {
		try {
			logger.info("EventService: createEvent " + event);
			Event eventResponse = eventRepository.save(event);
			return eventResponse;
		} catch (Exception e) {
			throw new EventCreationException("Event creation exception");
		}

	}

}
