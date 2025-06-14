package net.sergoncano.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sergoncano.domain.AuthenticationController;

@RequestMapping(AuthenticationControllerImplementation.URL)
@RestController
class AuthenticationControllerImplementation implements AuthenticationController{

	public static final String URL = "/api/authentication";

	@PostMapping(value = "/login", consumes = {"text/plain"})
	public ResponseEntity<String> login(@RequestBody String uuid) {
		System.out.println("A request has been recieved!");
		return new ResponseEntity<>("Test", HttpStatus.OK); 
	}
}
