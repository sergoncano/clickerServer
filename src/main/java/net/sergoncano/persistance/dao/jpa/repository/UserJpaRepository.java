package net.sergoncano.persistance.dao.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sergoncano.persistance.dao.jpa.entity.UserEntity;
/**
 * UserJpaRepository
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
	UserEntity findByUuid(String uuid);
}
