package com.vivek.service;

public interface UserService {
	void incrementPostCount(Long userId);

	void decrementPostCount(Long userId);
}
