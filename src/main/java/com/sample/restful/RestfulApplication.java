package com.sample.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}

}
//spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
//		spring.datasource.username=root
//		spring.datasource.password=123456
//
//		spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
//		spring.jpa.hibernate.ddl-auto=update