package com.klu.exam.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentSerivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSerivceApplication.class, args);
	}

}
