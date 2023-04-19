package com.vivek.controller;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Hidden
@Controller
public class HomeController {
	@Value("#{servletContext.contextPath}")
	private String contextPath;

	@Value("${springdoc.swagger-ui.path:index.html}")
	private String path;

	@GetMapping("/")
	public void home(HttpServletResponse response) throws IOException {
		response.sendRedirect(this.contextPath + path);
	}
}
