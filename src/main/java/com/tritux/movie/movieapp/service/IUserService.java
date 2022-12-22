/**
 * 
 */
package com.tritux.movie.movieapp.service;

import java.util.concurrent.ExecutionException;

import com.tritux.movie.movieapp.model.User;

/**
 * @author mmhamdi
 *
 */
public interface IUserService {
	
	public User getUser(String userName) throws InterruptedException, ExecutionException;

}
