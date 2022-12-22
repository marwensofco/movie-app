package com.tritux.movie.movieapp.enums;

/**
 * 
 * @author mmhamdi
 *
 */
public enum Plot {
	
	SHORT("short"),
	FULL("full");
	
	private final String plot;

	private Plot(String plot) {
		this.plot = plot;
	}
	

	 @Override
	    public String toString() {
		 return plot;
	 }

}
