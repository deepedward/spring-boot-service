package com.plan.code.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plan.code.bean.Event;

/**
 * Test Util class for 
 * 
 * @author deepakedward
 *
 */
public class TestHelper {

	public static Event eventRequest() {
		Event event = new Event();
		event.setName("Test Event 1");
		event.setPublished(true);
		return event;
	}
	
	public static Event createEvent(String eventName, boolean isPublished, long id) {
		Event event = new Event();
		event.setId(id);
		event.setName(eventName);
		event.setPublished(isPublished);
		return event;
	}

	public static byte[] toJson(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

}