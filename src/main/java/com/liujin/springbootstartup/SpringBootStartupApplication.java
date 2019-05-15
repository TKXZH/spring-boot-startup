package com.liujin.springbootstartup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootStartupApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartupApplication.class, args);
	}

}
