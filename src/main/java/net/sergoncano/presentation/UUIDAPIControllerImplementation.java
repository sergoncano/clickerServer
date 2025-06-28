package net.sergoncano.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sergoncano.domain.uuid.*;

@RequestMapping(UUIDAPIControllerImplementation .URL)
@RestController
public class UUIDAPIControllerImplementation implements UUIDAPIController {

	public static final String URL = "/api/UUIDs";
	private final UUIDService uuidService;

	@Autowired
	public UUIDAPIControllerImplementation(UUIDService uuidService) {
		this.uuidService = uuidService;
	}

	@GetMapping
	public String UUIDs(){
		String uuid = uuidService.getUUID().toString();
		return uuid;
	}
}
