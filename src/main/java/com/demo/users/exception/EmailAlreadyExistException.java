package com.demo.users.exception;

import com.demo.users.config.GlobalConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;
/**
 * Excepción personalizada que se lanza cuando se intenta crear un usuario con un correo electrónico
 * que ya existe en el sistema.
 * <p>
 * Esta clase extiende de {@link ErrorResponseException} y establece un estado HTTP CONFLICT (409)
 * junto con un {@link ProblemDetail} que contiene información detallada sobre el error.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
public class EmailAlreadyExistException extends ErrorResponseException {

    public EmailAlreadyExistException(String message){
        super(HttpStatus.CONFLICT, asProblemDetail(message), null);
    }

    private static ProblemDetail asProblemDetail(String message){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, message);
        problemDetail.setTitle(GlobalConstants.ENTITY_ALREADY_EXISTS);
        return problemDetail;
    }
}
