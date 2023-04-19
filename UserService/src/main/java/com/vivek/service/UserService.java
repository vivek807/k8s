package com.vivek.service;

import com.vivek.model.User;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class UserService extends BaseService<User> {
	public abstract void incrementPostCount(@PathVariable Long userId);
	public abstract void decrementPostCount(@PathVariable Long userId);
}
