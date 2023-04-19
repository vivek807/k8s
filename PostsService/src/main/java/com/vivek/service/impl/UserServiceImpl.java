package com.vivek.service.impl;

import com.vivek.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private RestTemplateBuilder restTemplateBuilder;
	@Value("${user.service.url}")
	private String userServiceUrl;

	private RestTemplate restTemplate;

	@PostConstruct
	protected void init() {
		this.restTemplate = restTemplateBuilder.rootUri(userServiceUrl).build();
	}

	@Override
	public void incrementPostCount(Long userId) {
		restTemplate.exchange("/users/{userId}/posts/increment", HttpMethod.PATCH,
			null,
			Void.class,
			userId);
	}

	@Override
	public void decrementPostCount(Long userId) {
		restTemplate.exchange("/users/{userId}/posts/decrement", HttpMethod.PATCH,
			null,
			Void.class,
			userId);
	}
}
