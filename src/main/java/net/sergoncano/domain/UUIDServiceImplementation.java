package net.sergoncano.domain;
import java.util.UUID;

public class UUIDServiceImplementation implements UUIDService {
	public UUID getUUID() {
		return UUID.randomUUID();
	}
}
