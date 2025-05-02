package com.demo.users.dto.common;

/**
 * ResponseCodeEnum.java
 * <p>
 * Enumeración que representa los códigos de respuesta para las APIs.
 * Contiene información sobre el código y el mensaje de respuesta.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
public enum ResponseCodeEnum {
	
	SUCCESS(1, "SUCCESS"),
	WARNING(2, "WARNING"),
	ERROR(3, "ERROR");
	
	private Integer responseCode;
	
	private String responseMessage;

	private ResponseCodeEnum(Integer responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}


}
