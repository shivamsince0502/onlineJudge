package com.example.coderock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CoderockApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoderockApplication.class, args);
	}

}
