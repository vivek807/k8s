package com.vivek.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class GreetingController {
	@Value("${build.version}") private String buildVersion;
	@Value("${application.name}") private String applicationName;

	@GetMapping("/greeting")
	public String greet() {
		return String.format("[%s.%s] Hello, K8s!", applicationName, buildVersion);
	}
}
