package net.sergoncano.persistance.dao;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import net.sergoncano.domain.model.User;
import net.sergoncano.persistance.dao.jpa.mapper.UserJpaMapper;
import net.sergoncano.persistance.dao.jpa.repository.UserJpaRepository;

/**
 * UserDaoDbImplementation
 */
public class UserDaoDbImplementation implements GenericDaoDb<User>{

	private UserJpaRepository userJpaRepository;

	@Autowired
	UserDaoDbImplementation(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public Optional<User> getByUuid(String uuid) {
		return Optional.ofNullable(userJpaRepository.findByUuid(uuid))
				.map(UserJpaMapper.INSTANCE::userEntityToUser);
	}

	@Override
	public void delete(String uuid) {
		try {
			userJpaRepository.delete(userJpaRepository.findByUuid(uuid));
		} catch (NoSuchElementException e) {
			System.out.println("Tried to delete non-existant entity.");
		}
	}

	@Override
	public ArrayList<User> getAll() {
		return (ArrayList<User>) userJpaRepository.findAll().stream().map(UserJpaMapper.INSTANCE::userEntityToUser).toList();
	}

	@Override
	public void insert(User t) {
		userJpaRepository.save(UserJpaMapper.INSTANCE.userToUserEntity(t));
	}

	@Override
	public void update(User t) {
		String uuid = t.getUuid();
		Optional<User> user = getByUuid(uuid);
		if(user.isEmpty()) {
			insert(t);
		} else {
			delete(t.getUuid());
			insert(t);
		}
	}

	@Override
	public int count() {
		return ((int) userJpaRepository.count());
	}
}
