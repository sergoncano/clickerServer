package net.sergoncano.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Person {
	private UUID uuid;
	private int clicks;
}
