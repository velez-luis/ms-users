package com.demo.users.exception;

import com.demo.users.config.GlobalConstants;
import com.demo.users.dto.common.CustomResponse;
import com.demo.users.dto.common.ResponseCodeEnum;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
/**
 * CustomResponseExceptionHandler.java
 * <p>
 * Manejador centralizado de excepciones para la aplicación.
 * Proporciona manejo específico para diferentes tipos de excepciones y genera
 * respuestas estandarizadas utilizando:
 * <ul>
 *     <li>CustomErrorResponse: Para errores técnicos</li>
 *     <li>CustomResponse: Para errores de negocio</li>
 * </ul>
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@RestControllerAdvice
@Hidden
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles all uncaught exceptions.
     *
     * @param ex      the exception that was thrown
     * @param request the current web request
     * @return a ResponseEntity containing a CustomErrorResponse with error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleAllException(Exception ex, WebRequest request) {
        CustomErrorResponse err = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles HttpClientErrorException.
     *
     * @param ex      the exception thrown by the HTTP client
     * @param request the current web request
     * @return a ResponseEntity containing a CustomResponse with error details
     */
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex, WebRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(ex.getStatusCode().value());
        response.setCodeEnum(ResponseCodeEnum.ERROR);
        response.setDateTime(LocalDateTime.now());
        response.setResponse(ex.getMessage());
        response.setMessage(request.getDescription(true));
        return new ResponseEntity<>(response, ex.getStatusCode());
    }

    /**
     * @param ex      the exception to handle
     * @param headers the headers to use for the response
     * @param status  the status code to use for the response
     * @param request the current request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCodeEnum(ResponseCodeEnum.ERROR);
        response.setDateTime(LocalDateTime.now());
        response.setResponse(ex.getMessage());
        return new ResponseEntity<>(response, ex.getStatusCode());
    }

    /**
     * Handles cases where no handler is found for a request.
     *
     * @param ex      the exception thrown when no handler is found
     * @param headers the headers to include in the response
     * @param status  the HTTP status code
     * @param request the current web request
     * @return a ResponseEntity containing a CustomResponse with error details
     */
    @Override
    protected ResponseEntity<Object> handleMethodValidationException(MethodValidationException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCodeEnum(ResponseCodeEnum.ERROR);
        response.setDateTime(LocalDateTime.now());
        response.setResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(status.value()));
    }

    /**
     * @param ex      the exception to handle
     * @param headers the headers to use for the response
     * @param status  the status code to use for the response
     * @param request the current request
     * @return
     */
    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseEntity<Object> handleEntityExistsException(EntityExistsException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(HttpStatus.CONFLICT.value());
        response.setCodeEnum(ResponseCodeEnum.ERROR);
        response.setDateTime(LocalDateTime.now());
        response.setResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    /**
     * @param ex      the exception to handle
     * @param headers the headers to use for the response
     * @param status  the status code to use for the response
     * @param request the current request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleErrorResponseException(ErrorResponseException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(ex.getStatusCode().value());
        response.setCodeEnum(ResponseCodeEnum.ERROR);
        response.setDateTime(LocalDateTime.now());
        response.setResponse(ex.getMessage());
        return new ResponseEntity<>(response, ex.getStatusCode());
    }

    /**
     * Handles the exception when a model is not found.
     *
     * @param ex      the exception thrown when a model is not found
     * @param request the current web request
     * @return a ResponseEntity containing a CustomResponse object with error details
     */
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(ex.getStatusCode().value());
        response.setCodeEnum(ResponseCodeEnum.ERROR);
        response.setDateTime(LocalDateTime.now());
        response.setResponse(ex.getMessage());
        return new ResponseEntity<>(response, ex.getStatusCode());
    }

    /**
     * Handles the exception when an email already exists.
     *
     * @param ex      the exception thrown when an email already exists
     * @param request the current web request
     * @return a ResponseEntity containing a CustomResponse object with error details
     */
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<CustomResponse> handleEmailNotFoundException(EmailAlreadyExistException ex, WebRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(ex.getStatusCode().value());
        response.setCodeEnum(ResponseCodeEnum.ERROR);
        response.setMessage(GlobalConstants.EMAIL_ALREADY_EXISTS);
        response.setDateTime(LocalDateTime.now());
        response.setResponse(ex.getMessage());
        return new ResponseEntity<>(response, ex.getStatusCode());
    }

    /**
     * Handles HttpRequestMethodNotSupportedException.
     *
     * @param ex      the exception thrown when a request method is not supported
     * @param headers the headers to include in the response
     * @param status  the HTTP status code
     * @param request the current web request
     * @return a ResponseEntity containing a CustomResponse with error details
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomResponse response = new CustomResponse();
        response.setCode(ex.getStatusCode().value());
        response.setCodeEnum(ResponseCodeEnum.ERROR);
        response.setDateTime(LocalDateTime.now());
        response.setResponse(ex.getMessage());
        return new ResponseEntity<>(response, ex.getStatusCode());
    }

    /**
     * Handles SQLException.
     *
     * @param ex  the exception thrown when a SQL error occurs
     * @param req the current web request
     * @return a ResponseEntity containing a CustomErrorResponse with error details
     */
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<CustomErrorResponse> handleSQLException(SQLException ex, WebRequest req) {
        CustomErrorResponse res = new CustomErrorResponse(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }

    /**
     * Handles MethodArgumentNotValidException.
     *
     * @param ex      the exception thrown when method arguments are invalid
     * @param headers the headers to include in the response
     * @param status  the HTTP status code
     * @param request the current web request
     * @return a ResponseEntity containing a CustomErrorResponse with error details
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        StringBuilder errorMsgBuilder = new StringBuilder();
        ex.getFieldErrors().forEach(error -> {
            String fieldName = error.getField().toUpperCase();
            String errorMessage = error.getDefaultMessage();
            errorMsgBuilder.append(fieldName)
                    .append(": ")
                    .append(errorMessage)
                    .append("|");
        });
        CustomErrorResponse err = new CustomErrorResponse(LocalDateTime.now(), errorMsgBuilder.toString(), request.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

}
