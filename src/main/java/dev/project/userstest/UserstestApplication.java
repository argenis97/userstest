package dev.project.userstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"dev.project.userstest.persistence.entity"})
public class UserstestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserstestApplication.class, args);
	}

}
