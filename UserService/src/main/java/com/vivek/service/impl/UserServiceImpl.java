package com.vivek.service.impl;

import com.vivek.exception.ApiException;
import com.vivek.model.User;
import com.vivek.repository.UserRepository;
import com.vivek.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl extends UserService {
	@Autowired private UserRepository userRepository;

	@Override
	public User add(User model) {
		if (this.userRepository.findByUsername(model.getUsername()).isPresent()) {
			throw ApiException.alreadyExists(model.getUsername());
		}

		return super.add(model);
	}

	@Override
	public User update(Long id, User model) {
		final var existing = this.validateAndGet(id);

		if (!existing.getUsername().equals(model.getUsername()) && this.userRepository.findByUsername(model.getUsername()).isPresent()) {
			throw ApiException.alreadyExists(model.getUsername());
		}

		model.setId(id);
		return super.save(model);
	}

	@Override
	public void incrementPostCount(Long userId) {
		var user = this.validateAndGet(userId);
		user.setAmountOfPosts(user.getAmountOfPosts() == null ? 1 : user.getAmountOfPosts() + 1);
	}

	@Override
	public void decrementPostCount(Long userId) {
		var user = this.validateAndGet(userId);
		user.setAmountOfPosts(user.getAmountOfPosts() == null ? 0 : user.getAmountOfPosts() - 1);
	}
}
