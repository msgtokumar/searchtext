package com.optus.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.optus.restapi"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class RestAPISpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAPISpringBootDemoApplication.class, args);
	}
}



