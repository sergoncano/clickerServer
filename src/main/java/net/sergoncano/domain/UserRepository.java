package net.sergoncano.domain;

import net.sergoncano.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
	public Optional<User> getByUUID(UUID uuid);
	public void AddUser(UUID uuid, String name);

	public void addScoreToUser(User user, int score);
	public int getSumOfScores();
}
