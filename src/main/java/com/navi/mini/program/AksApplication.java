package com.navi.mini.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.navi.mini.program")
public class AksApplication {

	public static void main(String[] args) {
		SpringApplication.run(AksApplication.class, args);
	}

}
