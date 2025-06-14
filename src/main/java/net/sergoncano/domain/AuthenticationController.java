package net.sergoncano.domain;

import org.springframework.http.ResponseEntity;

public interface AuthenticationController {
	public ResponseEntity<String> login(String uuid);
	public ResponseEntity<String> register(String name);
}
