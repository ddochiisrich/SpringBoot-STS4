package com.springbootclass.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringbootclassBbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootclassBbsApplication.class, args);
	}

}
