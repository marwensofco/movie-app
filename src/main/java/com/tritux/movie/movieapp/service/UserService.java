package com.tritux.movie.movieapp.service;


import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.tritux.movie.movieapp.model.User;


@Service
public class UserService implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	public User getUser(String userName) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<DocumentSnapshot> apiFuture = db.collection("user").document(userName).get();

		DocumentSnapshot document = apiFuture.get();
		if (document.exists()) {
			logger.info("User found: {}", userName);
			return document.toObject(User.class);
		}

		logger.info("User not found: {}", userName);
		return null;
	}
}