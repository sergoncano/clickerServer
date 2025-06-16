package net.sergoncano.persistance.dao.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import net.sergoncano.domain.model.User;
import net.sergoncano.persistance.dao.jpa.entity.UserEntity;

/**
 * UserJpaMapper
 */
@Mapper
public interface UserJpaMapper {

	UserJpaMapper INSTANCE = Mappers.getMapper(UserJpaMapper.class);
	
	@Mapping(source = "name", target = "username")
	UserEntity userToUserEntity(User user);

	@Mapping(source = "username", target = "name")
	User userEntityToUser(UserEntity userEntity);
}
