package com.demo.users.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * CustomResponse.java
 * <p>
 * Clase que representa una respuesta personalizada para las APIs.
 * Contiene información tanto del encabezado como del cuerpo de la respuesta.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse {
	
	//Header
	private ResponseCodeEnum codeEnum;
	private Integer code;
	private String message;
	private String uri;
	private LocalDateTime dateTime;
	//Body
	private Object response;
	
}
