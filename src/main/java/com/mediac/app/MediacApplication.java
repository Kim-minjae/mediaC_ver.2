package com.mediac.app;

import com.mediac.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class MediacApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MediacApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createUser("eee@gmail.com", "12345", "nickname1");
		// userService.lookup().forEach(t -> System.out.println(t));
	}
}
