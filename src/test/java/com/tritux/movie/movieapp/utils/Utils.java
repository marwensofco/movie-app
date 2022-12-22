package com.tritux.movie.movieapp.utils;

import java.util.ArrayList;
import java.util.List;

import com.tritux.movie.movieapp.enums.MovieType;
import com.tritux.movie.movieapp.model.Movie;

public class Utils {

	
	/**
	 * createMovies method
	 * 
	 * @return List<Movie>
	 */
	public static List<Movie> createMovies() {
		List<Movie> movies = new ArrayList<>();

		Movie movie = new Movie();
		movie.setId("12");
		movie.setTitle("title");
		movie.setMovieType(MovieType.SERIE);
		movies.add(movie);

		Movie movie1 = new Movie();
		movie1.setId("123");
		movie1.setTitle("title1");
		movie1.setMovieType(MovieType.SERIE);
		movies.add(movie1);

		return movies;
	}

	
}
