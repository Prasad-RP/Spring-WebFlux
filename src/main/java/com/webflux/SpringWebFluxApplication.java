package com.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxApplication.class, args);
	}
	
	@Autowired
	ReactiveMongoTemplate reactiveMongoTemplate;

	@PostConstruct
	public void checkq() {
	    reactiveMongoTemplate.getMongoDatabase()
	        .subscribe(db -> System.out.println("Connected DB: " + db.getName()));
	}
	
	
	@Autowired
	Environment env;

	@PostConstruct
	public void check() {
	    System.out.println("Mongo URI: " + env.getProperty("spring.data.mongodb.uri"));
	}

}
