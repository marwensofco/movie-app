package com.tritux.movie.movieapp.model;


import javax.validation.constraints.NotBlank;

import com.tritux.movie.movieapp.enums.MovieType;
import com.tritux.movie.movieapp.enums.Plot;

import lombok.Data;

/**
 * 
 * @author mmhamdi
 *
 */

@Data
public class Movie {

	@NotBlank(message = "id must not be blank")
	private String id;
	
	@NotBlank(message = "title must not be blank")
	private String title;
	
	@NotBlank(message = "type must not be blank")
	private MovieType movieType;
	
	@NotBlank(message = "year must not be blank")
	private Integer year;
	
	@NotBlank(message = "plot must not be blank")
	 private Plot plot;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	
	

	
	
	

}