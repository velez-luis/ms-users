package com.demo.users.dto.constraint.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * DominioCl.java
 * Anotación de validación personalizada que verifica si un correo electrónico
 * pertenece al dominio "@dominio.cl".
 * <p>
 * Esta anotación puede ser aplicada a campos o parámetros de tipo String que
 * representen direcciones de correo electrónico.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Documented
@Constraint(validatedBy = DominioClValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DominioCl {
    String message() default "Email must belong to @dominio.cl domain";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}