package com.demo.users.dto.constraint.password;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * PasswordConfig.java
 * <p>
 * Clase de configuración que gestiona las propiedades de validación de contraseñas.
 * Las propiedades se cargan desde el archivo de configuración usando el prefijo
 * "app.security.password.validation".
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "app.security.password.validation")
@Data
public class PasswordConfig {
    private String pattern;
    private String message;
}
