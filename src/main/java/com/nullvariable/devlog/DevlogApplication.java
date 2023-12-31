package com.nullvariable.devlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@EnableJpaRepositories
@SpringBootApplication
public class DevlogApplication {
	public static void main(String[] args) {
		String currentDirectory = System.getProperty("user.dir");

		try {
			Path userDirectory = Paths.get(currentDirectory + File.separator + "user/");
			if (!Files.exists(userDirectory) && !Files.isDirectory(userDirectory)) {
				Files.createDirectory(userDirectory);
			}

			Path profileDirectory = Paths.get(currentDirectory + File.separator + "user/profile/");
			if (!Files.exists(profileDirectory) && !Files.isDirectory(profileDirectory)) {
				Files.createDirectory(profileDirectory);
			}
		} catch (IOException e) {
			System.out.println("Required Directory");
			return;
		}

		SpringApplication.run(DevlogApplication.class, args);
	}
}
