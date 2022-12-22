package com.tritux.movie.movieapp.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tritux.movie.movieapp.dao.IGenericDao;
import com.tritux.movie.movieapp.model.Movie;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private IGenericDao<Movie> genericDAO;

	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

	/**
	 * Create new user
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tritux.movie.movieapp.service.IMovieService#create(com.tritux.movie.
	 * movieapp.entity.Movie)
	 */
	@Override
	public Movie create(Movie movie) throws InterruptedException, ExecutionException {
		String documentId = UUID.randomUUID().toString();
		logger.info("The title of movie we will be created is : {}", movie.getTitle());
		movie.setId(documentId);

		return genericDAO.create(movie, "movie", movie.getId().toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tritux.movie.movieapp.service.IMovieService#findAll()
	 */
	@Override
	public List<Movie> findAll() throws InterruptedException, ExecutionException {
		logger.info("retreive all movies");
		return genericDAO.findAll(Movie.class, "movie");

	}

}