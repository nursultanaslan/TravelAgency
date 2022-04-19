package com.oop.agency;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
//		SpringApplication.run(NamelessApplication.class, args);
		JavaFxApplication.launch(JavaFxApplication.class, args);
	}

}
