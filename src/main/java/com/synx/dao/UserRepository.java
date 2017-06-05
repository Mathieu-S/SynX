package com.synx.dao;

import org.springframework.data.repository.CrudRepository;

import com.synx.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
