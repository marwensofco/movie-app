package com.tritux.movie.movieapp.service;


import java.util.List;
import java.util.concurrent.ExecutionException;

import com.tritux.movie.movieapp.model.Movie;

public interface IMovieService {
	/**
	 * @param movie
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public Movie create(Movie movie) throws InterruptedException, ExecutionException;
	/**
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public List<Movie> findAll() throws InterruptedException, ExecutionException;
	
}
