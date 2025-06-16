package net.sergoncano.domain.uuid;

import java.util.UUID;
import net.sergoncano.common.annotation.*;

@DomainService
public class UUIDServiceImplementation implements UUIDService {
	public UUID getUUID() {
		return UUID.randomUUID();
	}
}
