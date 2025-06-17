package net.sergoncano.persistance.dao;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import net.sergoncano.common.annotation.PersistanceRepository;
import net.sergoncano.domain.model.User;
import net.sergoncano.persistance.dao.jpa.mapper.UserJpaMapper;
import net.sergoncano.persistance.dao.jpa.repository.UserJpaRepository;

/**
 * UserDaoDbImplementation
 */
@PersistanceRepository
public class UserDaoDbImplementation implements UserDaoDb{

	private UserJpaRepository userJpaRepository;
	private UserJpaMapper userJpaMapper;

	@Autowired
	UserDaoDbImplementation(UserJpaRepository userJpaRepository, UserJpaMapper userJpaMapper) {
		this.userJpaRepository = userJpaRepository;
		this.userJpaMapper = userJpaMapper;
	}

	@Override
	public Optional<User> getByUuid(String uuid) {
		return Optional.ofNullable(userJpaRepository.findByUuid(uuid))
				.map(userJpaMapper::userEntityToUser);
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
		return (ArrayList<User>) userJpaRepository.findAll().stream().map(userJpaMapper::userEntityToUser).toList();
	}

	@Override
	public void insert(User t) {
		userJpaRepository.save(userJpaMapper.userToUserEntity(t));
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
