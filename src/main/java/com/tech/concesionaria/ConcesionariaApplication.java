package com.tech.concesionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class ConcesionariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcesionariaApplication.class, args);

	}

}
