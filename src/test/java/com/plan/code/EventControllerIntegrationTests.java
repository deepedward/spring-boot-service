package com.plan.code;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.plan.code.bean.Event;
import com.plan.code.util.TestHelper;

/**
 * EventControllerIntegrationTests to validate and test the Rest APIs
 * 
 * @author deepakedward
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
class EventControllerIntegrationTests {

	@Autowired
	private MockMvc mockRequest;

	@Test
	public void eventNotPresenTest() throws Exception {
		mockRequest.perform(MockMvcRequestBuilders.get("/api/v1/events/101")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()));
	}

	@Test
	public void createEventTest() throws Exception {
		Event event = TestHelper.eventRequest();
		mockRequest
				.perform(MockMvcRequestBuilders.post("/api/v1/events").contentType(MediaType.APPLICATION_JSON)
						.content(TestHelper.toJson(event)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test Event 1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.published").value(true));

		mockRequest.perform(MockMvcRequestBuilders.get("/api/v1/events/1")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));
	}
}
