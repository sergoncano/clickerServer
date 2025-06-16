package net.sergoncano.persistance.dao.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserEntity
 */
@Entity
@Table(name="Users")
@Data
@NoArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "UUID")
	private String uuid;

	private String username;
	private Integer score;
}
