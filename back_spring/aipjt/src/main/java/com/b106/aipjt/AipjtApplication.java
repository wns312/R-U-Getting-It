package com.b106.aipjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AipjtApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
        + "classpath:application.yml,"
        + "classpath:aws.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(AipjtApplication.class)
            .properties(APPLICATION_LOCATIONS)
            .run(args);
    }

//	public static void main(String[] args) {
//		SpringApplication.run(AipjtApplication.class, args);
//	}

}
