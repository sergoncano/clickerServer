package net.sergoncano.persistance;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import net.sergoncano.domain.user.UserRepository;
import net.sergoncano.common.annotation.PersistanceRepository;
import net.sergoncano.domain.model.User;
import net.sergoncano.persistance.dao.UserDaoDb;

@PersistanceRepository
public class UserRepositoryImplementation implements UserRepository {
	private UserDaoDb userDaoDb;

	@Autowired
	public UserRepositoryImplementation(UserDaoDb userDaoDb) {
		this.userDaoDb = userDaoDb;
	}

	public Optional<User> getByUUID(String uuid) {
		return userDaoDb.getByUuid(uuid);
	}

	public void AddUser(User user){
		if(user.getScore()==0)
			userDaoDb.insert(user);
		else
			System.out.println("Tried to add a non-zero score user.");
	}

	public void addScoreToUser(User user, int score) {
		User newUser = user;
		newUser.setScore(newUser.getScore() + score);
		userDaoDb.update(newUser);
	}
}
