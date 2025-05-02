package com.demo.users.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
/**
 * CustomErrorResponse.java
 * <p>
 * Clase que representa la estructura de respuesta para errores personalizados.
 * Contiene información sobre:
 * <ul>
 *     <li>datetime: Fecha y hora del error</li>
 *     <li>message: Mensaje descriptivo del error</li>
 *     <li>details: Detalles adicionales del error</li>
 * </ul>
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {

    private LocalDateTime datetime;
    private String message;
    private String details;
}
