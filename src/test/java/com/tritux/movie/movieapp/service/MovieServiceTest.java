package com.tritux.movie.movieapp.service;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tritux.movie.movieapp.enums.MovieType;
import com.tritux.movie.movieapp.enums.Plot;
import com.tritux.movie.movieapp.model.Movie;
import com.tritux.movie.movieapp.utils.Utils;

@SpringBootTest
public class MovieServiceTest {
	
	@Autowired
	private IMovieService iMovieService;
	/**
	 * The logger.
	 */
	@MockBean
	private Logger logger;
	
	private static final String MOVIE_TYPE="episode";
	
	
	
	@Test
	public void testCreate() throws InterruptedException, ExecutionException {
		Movie movie = iMovieService.create(Utils.createMovies().get(0));
		String movieType = MOVIE_TYPE;
		movie.setMovieType(MovieType.EPISODE);
		movie.setPlot(Plot.FULL);
		movie = iMovieService.create(movie);
		Assertions.assertEquals(movieType, movie.getMovieType());
	}
	
	@Test
	public void testFindAll() throws InterruptedException, ExecutionException {
		Assertions.assertTrue(!iMovieService.findAll().isEmpty());
		Assertions.assertEquals(Utils.createMovies().size(),2);
	}

}
