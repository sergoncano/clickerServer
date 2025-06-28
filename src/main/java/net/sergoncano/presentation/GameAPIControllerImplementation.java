package net.sergoncano.presentation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sergoncano.domain.game.GameAPIController;
import net.sergoncano.domain.model.User;
import net.sergoncano.domain.user.UserRepository;

/**
 * GameAPIControllerImplementation
 */
@RestController
@RequestMapping(GameAPIControllerImplementation.URL)
public class GameAPIControllerImplementation implements GameAPIController{

	public static final String URL = "/api/game";
	private UserRepository userRepository;
	
	@Autowired
	public GameAPIControllerImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping(value = "/click", consumes = {"text/plain"})
	public ResponseEntity<String> click(@RequestBody String uuid) {
		Optional<User> user = userRepository.getByUUID(uuid);
		if(!user.isEmpty()) {
			User userObject = user.get();
			userRepository.addScoreToUser(userObject, 1);
			return ResponseEntity.status(HttpStatus.OK).body("Success.");
		} else {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("There was an error increasing your score.");
		}
	}

	@GetMapping("/score/{uuid}")
	public ResponseEntity<Integer> score(@PathVariable String uuid){
		Optional<User> user = userRepository.getByUUID(uuid);
		if(!user.isEmpty()) {
			User userObject = user.get();
			return ResponseEntity.status(HttpStatus.OK).body(userObject.getScore());
		} else {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(0);
		}
	}
}
