package net.sergoncano.persistance.dao;

import java.util.ArrayList;
import java.util.Optional;

public interface GenericDaoDb<T> {
	ArrayList<T> getAll();
	Optional<T> getByUuid(String uuid);
	void insert(T t);
	void update(T t);
	void delete(String uuid);
	int count();
}
