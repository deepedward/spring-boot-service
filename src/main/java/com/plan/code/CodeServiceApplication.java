package com.plan.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author deepakedward
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.plan.code" })
public class CodeServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CodeServiceApplication.class, args);
	}

}
