package com.demo.users.dto.constraint.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;
/**
 * PasswordConstraintValidator.java
 * <p>
 * Validador personalizado que implementa la anotación {@link ValidPassword}.
 * Verifica que las contraseñas cumplan con el patrón definido en la configuración.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private final PasswordConfig config;
    private Pattern pattern;

    public PasswordConstraintValidator(PasswordConfig config) {
        this.config = config;
    }

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        pattern = Pattern.compile(config.getPattern());
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            buildValidationError(context, "La contraseña no puede ser nula");
            return false;
        }

        if (!pattern.matcher(password).matches()) {
            buildValidationError(context, config.getMessage());
            return false;
        }
        return true;
    }

    private void buildValidationError(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }
}
