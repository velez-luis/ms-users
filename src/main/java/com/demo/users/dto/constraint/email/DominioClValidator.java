package com.demo.users.dto.constraint.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/**
 * DominioClValidator.java
 * <p>
 * Validador personalizado que implementa la anotación {@link DominioCl}.
 * Verifica que las direcciones de correo electrónico terminen con el dominio "@dominio.cl".
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
public class DominioClValidator implements ConstraintValidator<DominioCl, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return true; /* Permitimos las validaciones con @Notblank */
        }
        return email.toLowerCase().endsWith("@dominio.cl");
    }
}
