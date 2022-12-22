package com.tritux.movie.movieapp.dao;


import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Interface to interact with firebase
 * @author mmhamdi
 *
 * @param <T>
 */

public interface IGenericDao<T> {
	/**
	 * @param obj
	 * @param nomColeccion
	 * @param documentId
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public T create(T obj, String nomColeccion, String documentId) 
			throws InterruptedException, ExecutionException;
	
	
	/**
	 * @param obj
	 * @param nomColeccion
	 * @param documentId
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public  T findById(Class<T>  obj, String nomColeccion, String documentId) 
			throws InterruptedException, ExecutionException;
	
	/**
	 * @param obj
	 * @param nomColeccion
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public List<T> findAll(Class<T> obj, String nomColeccion) 
			throws InterruptedException, ExecutionException;
}
