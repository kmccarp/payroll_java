package com.waffle.openpayroll.web;

import java.util.List;

import com.waffle.openpayroll.domain.User;

/**
 * Service to find users
 * 
 * @author Kevin
 *
 */
public interface UserRetrievalService {

	/**
	 * Find ALL users
	 * 
	 * @return List of all users
	 */
	List<User> findAll();
	
	/**
	 * Finds user by their username, {@code null} if none is found
	 * 
	 * @param username User's username
	 * @return The user if one is found, {@code null} otherwise
	 */
	User findByUsername(String username);

}