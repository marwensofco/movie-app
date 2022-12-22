package com.tritux.movie.movieapp.enums;

/***
 * 
 * @author mmhamdi
 *
 */
public enum MovieType {
	
	MOVIE ("movie"),
	EPISODE("episode"),
	SERIE("series");
	
	private final String type;

	private MovieType(String type) {
		this.type = type;
	}
	

	 @Override
	    public String toString() {
		 return type;
	 }
	
}
