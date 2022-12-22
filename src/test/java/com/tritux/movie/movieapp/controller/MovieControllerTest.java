package com.tritux.movie.movieapp.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tritux.movie.movieapp.model.Movie;
import com.tritux.movie.movieapp.service.IMovieService;
import com.tritux.movie.movieapp.utils.Utils;

@WebMvcTest(MovieController.class)
@ContextConfiguration
public class MovieControllerTest {

	@MockBean
	private IMovieService iMovieService;
	@Autowired
	private MockMvc mvc;
	@MockBean
	private RestTemplate restTemplate;
	@Autowired
	ObjectMapper objectMapper;

	private static final String MOVIE_CREATE_URL = "/api/movie/create";

	private static final String MOVIE_GET_URL = "/api/movie/get";

	@Test
	public void testCreate() throws Exception {
		Movie movie = Utils.createMovies().get(0);
		given(iMovieService.create(movie)).willReturn(movie);
		mvc.perform(post(MOVIE_CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(asJsonString(movie)))
				.andExpect(status().is4xxClientError());

	}

	@Test
	public void testGet() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(MOVIE_GET_URL);
		MockHttpServletResponse result = mvc.perform(requestBuilder).andExpect(status().is4xxClientError()).andReturn()
				.getResponse();
		if (result != null && !result.getContentAsString().isEmpty()) {
			Movie response = objectMapper.readValue(result.getContentAsString(), Movie.class);

			Assertions.assertEquals(response.getMovieType(), "series");
		}
	}

	/**
	 * asJsonString method ()
	 * 
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	private String asJsonString(final Object obj) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(obj);
	}

}
