package net.sergoncano.domain.game;

import org.springframework.http.ResponseEntity;

/**
 * GameAPIController
 */
public interface GameAPIController {
	public ResponseEntity<String> click(String uuid);
	public ResponseEntity<Integer> score(String uuid);
}
