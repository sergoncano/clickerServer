package net.sergoncano.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sergoncano.domain.authentication.AuthenticationController;
import net.sergoncano.domain.authentication.AuthenticationService;

@RequestMapping(AuthenticationControllerImplementation.URL)
@RestController
class AuthenticationControllerImplementation implements AuthenticationController{

	public static final String URL = "/api/authentication";
	private AuthenticationService authenticationService;

	@Autowired
	public AuthenticationControllerImplementation(AuthenticationService authenticationService) {
		this.authenticationService= authenticationService; 
	}

	@PostMapping(value = "/login", consumes = {"text/plain"})
	public ResponseEntity<String> login(@RequestBody String uuid) {
		System.out.println("A login request has been recieved. UUID: " + uuid);
		return authenticationService.login(uuid);
	}

	@PostMapping(value = "/register", consumes = {"text/plain"})
	public ResponseEntity<String> register(@RequestBody String name) {
		System.out.println("A register request has been recieved. Username: " + name);
		return authenticationService.register(name);
	}
}
