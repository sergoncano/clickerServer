package net.sergoncano.persistance;

import java.util.Optional;

import net.sergoncano.domain.user.UserRepository;
import net.sergoncano.common.annotation.PersistanceRepository;
import net.sergoncano.domain.model.User;

@PersistanceRepository
public class UserRepositoryImplementation implements UserRepository {

	public Optional<User> getByUUID(String uuid) {
		return Optional.empty();
	}

	public void AddUser(String uuid, String name){
	}

	public void addScoreToUser(User user, int score) {
	}

	public int getSumOfScores() {
		return 0;
	}

}
