package com.teched.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechEdApplication {

    private static final Logger logger = LoggerFactory.getLogger(TechEdApplication.class);

	
	public static void main(String[] args) {
		
        logger.info("Starting Teched Application...");
		SpringApplication.run(TechEdApplication.class, args);
		
	}

}
