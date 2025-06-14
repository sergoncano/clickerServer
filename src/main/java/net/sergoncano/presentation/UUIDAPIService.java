package net.sergoncano.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sergoncano.domain.*;

@RequestMapping(UUIDAPIService.URL)
@RestController
public class UUIDAPIService {

	public static final String URL = "/api/UUIDs";

	private final UUIDService uuidService = new UUIDServiceImplementation();

	@GetMapping("/")
	private String UUIDs(){
		return uuidService.getUUID().toString();
	}
}
