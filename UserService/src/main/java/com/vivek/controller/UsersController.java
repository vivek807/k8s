package com.vivek.controller;

import com.vivek.model.User;
import com.vivek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController extends BaseRestController<User> {
	@Autowired private UserService userService;

	@PatchMapping("/{userId}/posts/increment")
	public void incrementPostCount(@PathVariable Long userId) {
		this.userService.incrementPostCount(userId);
	}

	@PatchMapping("/{userId}/posts/decrement")
	public void decrementPostCount(@PathVariable Long userId) {
		this.userService.decrementPostCount(userId);
	}
}
