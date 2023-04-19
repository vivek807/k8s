package com.vivek.service.impl;

import com.vivek.model.UserPost;
import com.vivek.service.UserPostService;
import com.vivek.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserPostServiceImpl extends UserPostService {
	@Autowired private UserService userService;

	@Override
	public UserPost add(UserPost model) {
		var result = super.add(model);
		userService.incrementPostCount(model.getAuthorId());
		return result;
	}

	@Override
	public void delete(Long id) {
		final var userPost = this.validateAndGet(id);
		this.repository.delete(userPost);
		userService.decrementPostCount(userPost.getAuthorId());
	}
}
