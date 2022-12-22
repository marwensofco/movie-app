package com.tritux.movie.movieapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tritux.movie.movieapp.model.Movie;
import com.tritux.movie.movieapp.service.MovieService;

/**
 * 
 * @author mmhamdi
 *
 */
@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/movie")
public class MovieController {

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieService movieService;
	/**
	 * the MESSAGE_RESPONSE
	 */
	private static final String MESSAGE_RESPONSE = "message";

	/**
	 * @param movie
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Movie movie) throws InterruptedException, ExecutionException {
		Map<String, Object> response = new HashMap<>();

		Movie movieCreated = movieService.create(movie);
		if (movieCreated != null) {
			logger.info("The movie title created is : {}",movieCreated.getTitle());
			response.put("movie", movieCreated);
			response.put(MESSAGE_RESPONSE, "ok");
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED); // 201

	}

	/**
	 * @return
	 */
	@GetMapping("/findAll")
	public ResponseEntity<?> getAll() {

		Map<String, Object> response = new HashMap<>();
		List<Movie> listOfMovies = null;

		try {
			logger.info("retreive all movies");
			listOfMovies = movieService.findAll();

		} catch (Exception e) {
			response.put(MESSAGE_RESPONSE, "db error");
			response.put("error", e.getMessage().concat(": "));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put(MESSAGE_RESPONSE, "ok");
		response.put("movie", listOfMovies);

		return new ResponseEntity<>(response, HttpStatus.OK); // 200

	}

}
