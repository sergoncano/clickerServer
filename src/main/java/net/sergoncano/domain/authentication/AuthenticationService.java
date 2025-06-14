package net.sergoncano.domain.authentication;

import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
	public ResponseEntity<String> login(String uuid);
	public ResponseEntity<String> register(String user);
}
