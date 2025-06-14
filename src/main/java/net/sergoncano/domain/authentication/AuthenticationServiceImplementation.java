package net.sergoncano.domain.authentication;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import net.sergoncano.domain.model.User;
import net.sergoncano.domain.user.UserRepository;

public class AuthenticationServiceImplementation implements AuthenticationService {

	private UserRepository userRepository;

	@Autowired
	public AuthenticationServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseEntity<String> login(String uuid) {
		Optional<User> user = userRepository.getByUUID(UUID.fromString(uuid));
		if(user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("The provided user identifier is not valid.");
		}
	}
}
