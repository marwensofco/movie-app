package com.tritux.movie.movieapp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tritux.movie.movieapp.model.User;
import com.tritux.movie.movieapp.service.IUserService;

@WebMvcTest(UserController.class)
@ContextConfiguration
public class UserControllerTest {

	@MockBean
	private IUserService iUserService;
	@Autowired
	private MockMvc mvc;
	@MockBean
	private RestTemplate restTemplate;
	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void testGet() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user");
		MockHttpServletResponse result = mvc.perform(requestBuilder).andExpect(status().is4xxClientError()).andReturn()
				.getResponse();
		if (result != null && !result.getContentAsString().isEmpty()) {
			User response = objectMapper.readValue(result.getContentAsString(), User.class);

			Assertions.assertEquals(response.getUserName(),"marwen");
		}
	}

}
