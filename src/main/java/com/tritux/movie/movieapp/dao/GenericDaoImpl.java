package com.tritux.movie.movieapp.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;


/**
 * Interface implementation to interact with firebase
 * @author mmhamdi
 *
 * @param <T>
 */
public class GenericDaoImpl<T> implements IGenericDao<T> {

	
	/* (non-Javadoc)
	 * @see com.tritux.movie.movieapp.dao.IGenericDao#create(java.lang.Object, java.lang.String, java.lang.String)
	 */
	public T create(T obj, String nomColeccion, String documentId) throws InterruptedException, ExecutionException {
		Firestore dbFireStore = FirestoreClient.getFirestore();
		
		ApiFuture<WriteResult> collectionApiFuture = dbFireStore.collection(nomColeccion).document(documentId).set(obj);
		T returnObject = null;
		
		while(!collectionApiFuture.isDone()) {}
		
		returnObject = findById((Class<T>) obj.getClass(), nomColeccion, documentId);
		
		return returnObject;
		
	}

	/* (non-Javadoc)
	 * @see com.tritux.movie.movieapp.dao.IGenericDao#findById(java.lang.Class, java.lang.String, java.lang.String)
	 */
	@Override
	public T findById(Class<T> obj, String nomColeccion, String documentId)
			throws InterruptedException, ExecutionException {
		Firestore dbFireStore = FirestoreClient.getFirestore();
		DocumentReference docRef = dbFireStore.collection(nomColeccion).document(documentId);
		// asynchronously retrieve the document
		ApiFuture<DocumentSnapshot> future = docRef.get();
		// block on response
		DocumentSnapshot document = future.get();
		T objectReturn = null;
		if (document.exists()) {
		  // convert document to POJO
			objectReturn = document.toObject(obj);
		} 
		
		return objectReturn;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	
	public List<T> findAll(Class<T> obj, String nomColeccion) throws InterruptedException, ExecutionException {
		List<T> listMovies = new ArrayList<>();
		FirestoreClient.getFirestore();
		// asynchronously retrieve multiple documents
		ApiFuture<QuerySnapshot> future = null;
				
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (DocumentSnapshot document : documents) {
			listMovies.add(document.toObject(obj));
		}

		return listMovies;
	}
	
}