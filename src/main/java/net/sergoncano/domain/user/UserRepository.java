package net.sergoncano.domain.user;

import net.sergoncano.domain.model.User;
import java.util.Optional;

public interface UserRepository {
	public Optional<User> getByUUID(String uuid);
	public void AddUser(User user);

	public void addScoreToUser(User user, int score);
}
