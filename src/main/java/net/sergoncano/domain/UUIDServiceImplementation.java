package net.sergoncano.domain;

import java.util.UUID;
import net.sergoncano.common.annotation.*;

import org.springframework.stereotype.Service;

@DomainService
public class UUIDServiceImplementation implements UUIDService {
	public UUID getUUID() {
		return UUID.randomUUID();
	}
}
