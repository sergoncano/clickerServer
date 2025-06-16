package net.sergoncano.domain.user;

import net.sergoncano.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
	public Optional<User> getByUUID(String uuid);
	public void AddUser(String uuid, String name);

	public void addScoreToUser(User user, int score);
	public int getSumOfScores();
}
