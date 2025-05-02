package com.demo.users.dto.constraint.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * ValidPassword.java
 * <p>
 * Anotación de validación personalizada para contraseñas.
 * Verifica que las contraseñas cumplan con el patrón definido en la configuración.
 * Se puede aplicar a campos y parámetros.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "La contraseña no cumple con los requisitos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}