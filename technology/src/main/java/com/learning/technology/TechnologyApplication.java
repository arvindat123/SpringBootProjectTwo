package com.learning.technology;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication()
@EnableScheduling
@EnableWebMvc
@EnableJpaRepositories
public class TechnologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologyApplication.class, args);
	}

	//Generating Swagger
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public")
				.packagesToScan("com.learning.technology.controller")
				.build();
	}
}
