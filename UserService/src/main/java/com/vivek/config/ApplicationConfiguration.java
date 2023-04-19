package com.vivek.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public OpenAPI openAPI(@Value("${application.name}") String applicationName,
		@Value("${application.description}") String applicationDescription,
		@Value("${build.version}") String buildVersion) {
		return new OpenAPI().info(new Info().title(applicationName)
			.description(applicationDescription)
			.version(buildVersion)
			.license(new License().name("Apache 2.0")));
	}
}
