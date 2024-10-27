package com.dsi.tp.bonvino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpdsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpdsiApplication.class, args);
		System.out.println("Corriendo en: "+ "http://localhost:8080");
	}

}
