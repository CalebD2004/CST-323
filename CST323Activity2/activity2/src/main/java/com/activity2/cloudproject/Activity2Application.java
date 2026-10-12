package com.activity2.cloudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.activity2.cloudproject"})

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication 
@EnableJpaRepositories(basePackages = "com.activity2.cloudproject.repository")
public class Activity2Application {

	public static void main(String[] args) {
		SpringApplication.run(Activity2Application.class, args);
	}

}
