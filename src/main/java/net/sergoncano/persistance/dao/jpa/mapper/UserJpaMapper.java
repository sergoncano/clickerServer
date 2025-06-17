package net.sergoncano.persistance.dao.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import net.sergoncano.domain.model.User;
import net.sergoncano.persistance.dao.jpa.entity.UserEntity;

/**
 * UserJpaMapper
 */
public interface UserJpaMapper {

	UserEntity userToUserEntity(User user);

	User userEntityToUser(UserEntity userEntity);
}
