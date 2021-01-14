package io.basav.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieCatalogServiceApplication {

	public static void main(String[] args) {
		System.out.println("Spring Cloud Applications");
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
