package net.sergoncano.domain.authentication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.sergoncano.domain.model.User;
import net.sergoncano.domain.user.UserRepository;
import net.sergoncano.domain.uuid.UUIDService;

import net.sergoncano.common.annotation.*;

@DomainService
public class AuthenticationServiceImplementation implements AuthenticationService {

	private UserRepository userRepository;
	private UUIDService uuidService;

	@Autowired
	public AuthenticationServiceImplementation(UserRepository userRepository, UUIDService uuidService) {
		this.userRepository = userRepository;
		this.uuidService = uuidService;
	}

	public ResponseEntity<String> login(String uuid) {
		Optional<User> user = userRepository.getByUUID(uuid);
		if(user.isEmpty()) 
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("The provided user identifier is not valid.");
		else 
			return ResponseEntity.status(HttpStatus.OK).body("Login successful.");
	}

	public ResponseEntity<String> register(String name) {
		try {
			String uuid = uuidService.getUUID().toString();
			User user = new User(uuid, name, 0);
			userRepository.AddUser(user);
			return ResponseEntity.status(HttpStatus.OK).body(uuid);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was an error creating the user.");
		}
	}
}
