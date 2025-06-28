package net.sergoncano.domain.authentication;

import org.springframework.http.ResponseEntity;

public interface AuthenticationController {
	/**
	 * Takes the user's uuid and returns their username.
	 */
	public ResponseEntity<String> login(String uuid);

	/**
	 * Takes the new user's username and returns their uuid
	 */
	public ResponseEntity<String> register(String name);
}
