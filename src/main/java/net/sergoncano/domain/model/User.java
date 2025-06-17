package net.sergoncano.domain.model;

public class User {
	private String uuid;
	private String name;
	private int score;

	public User(String uuid, String name, int score) {
		this.uuid = uuid;
		this.name = name;
		this.score = score;
	}

	public String getUuid() {
		return this.uuid;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof User) && ((User) other).getUuid() == this.uuid;
	}
}


