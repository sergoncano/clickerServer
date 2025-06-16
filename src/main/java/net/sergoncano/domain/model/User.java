package net.sergoncano.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
	private String uuid;
	private String name;
	private int score;

}
