package net.sergoncano.persistance.dao.jpa.mapper;

import net.sergoncano.common.annotation.PersistanceRepository;
import net.sergoncano.domain.model.User;
import net.sergoncano.persistance.dao.jpa.entity.UserEntity;

/**
 * UserJpaMapperImplementation
 */
@PersistanceRepository
public class UserJpaMapperImplementation implements UserJpaMapper {
	
	public UserEntity userToUserEntity(User user) {
		return new UserEntity(user.getUuid(), user.getName(), user.getScore());
	}

	public User userEntityToUser(UserEntity userEntity) {
		return new User(userEntity.getUuid(), userEntity.getUsername(), userEntity.getScore());
	}
}
