package com.openpayroll.web;

/**
 * Service to send and receive authentication information
 * 
 * @author Kevin
 * 
 */
public interface AuthenticationService {

	/**
	 * Check to see if the given username and password are valid.
	 * 
	 * @param username
	 *            The username
	 * @param password
	 *            The password
	 * @return {@code true} if the username and password are valid;
	 *         {@code false} otherwise
	 */
	boolean isAuthenticated(String username, String password);
}
