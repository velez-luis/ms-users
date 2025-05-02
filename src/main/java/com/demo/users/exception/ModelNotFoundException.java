package com.demo.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;
/**
 * Excepción personalizada que se lanza cuando no se encuentra un modelo en el sistema.
 * <p>
 * Esta clase extiende de {@link ErrorResponseException} y establece un estado HTTP NOT_FOUND (404)
 * junto con un {@link ProblemDetail} que contiene información detallada sobre el error.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
public class ModelNotFoundException extends ErrorResponseException {

    public ModelNotFoundException(String message){
        super(HttpStatus.NOT_FOUND, asProblemDetail(message), null);
    }

    private static ProblemDetail asProblemDetail(String message){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setTitle("Model Not Found");
        return problemDetail;
    }
}
