package com.vivek.repository;

import com.vivek.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
	Optional<User> findByUsername(String name);
}
