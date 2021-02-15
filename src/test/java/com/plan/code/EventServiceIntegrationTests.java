package com.plan.code;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.plan.code.bean.Event;
import com.plan.code.exception.EventNotFoundException;
import com.plan.code.repository.EventRepository;
import com.plan.code.service.EventService;
import com.plan.code.util.TestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceIntegrationTests {

	@TestConfiguration
	static class EventServiceTestContextConfiguration {
		@Bean
		public EventService eventService() {
			return new EventService();
		}
	}

	@Autowired
	private EventService service;

	@MockBean
	private EventRepository repository;

	@Before
	public void setUp() {
		Event e1 = TestHelper.createEvent("event1", true, 1);
		Event e2 = TestHelper.createEvent("event2", true, 2);
		Event e3 = TestHelper.createEvent("event3", true, 3);

		Mockito.when(repository.findById(e1.getId())).thenReturn(Optional.of(e1));
		Mockito.when(repository.findById(e2.getId())).thenReturn(Optional.of(e2));
		Mockito.when(repository.findById(e3.getId())).thenReturn(Optional.of(e3));
	}

	@Test
	public void whenEvenExistsTest() throws EventNotFoundException {
		String eventName = "event1";
		Event event = service.fetchEvent(1);
		assertTrue(event.getName() == eventName);

		String eventName2 = "event2";
		Event event2 = service.fetchEvent(2);
		assertTrue(event2.getName() == eventName2);
	}

	@Test
	public void whenEvenDoesNotExistsTest() {
		assertThrows(EventNotFoundException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				service.fetchEvent(101);
			}
		});
	}

}
