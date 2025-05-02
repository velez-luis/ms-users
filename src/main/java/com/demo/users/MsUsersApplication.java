package com.demo.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * MsUsersApplication.java
 * <p>
 * Clase principal de la aplicación Spring Boot que gestiona el microservicio
 * de usuarios. Esta clase contiene el punto de entrada de la aplicación y
 * habilita la configuración automática de Spring Boot.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@SpringBootApplication
public class MsUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUsersApplication.class, args);
	}

}
