package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;

@OpenAPIDefinition(
    info = @Info(
        title = "Ecommerce Book Store Mangement",
        version = "1.0",
        description = "Welcome to the Naresh I Technologies",
        contact = @Contact(
            name = "Naresh IT Technology",
            email = "mani@gmail.com"
        )))

@SpringBootApplication
public class ECOnlineShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECOnlineShoppingApplication.class, args);
	}

}
