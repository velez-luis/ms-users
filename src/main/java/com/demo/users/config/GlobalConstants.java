package com.demo.users.config;

/**
 * GlobalConstants.java
 * <p>
 * This class contains global constants used throughout the application.
 * It includes date formats and error messages.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
public class GlobalConstants {

    /** DATETIME STRING FORMAT HELPERS */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String MODEL_NOT_FOUND = "%s con %s %s no encontrado.";
    public static final String ENTITY_ALREADY_EXISTS = "Ya EXISTE el registro en base de datos";
    public static final String EMAIL_ALREADY_EXISTS = "El correo ya se encuentra registrado";

    public static final String USER_NOT_FOUND = "Usuario no encontrado :";
    public static final String USER_ID_NOT_FOUND = "ID de Usuario no encontrado :";

    private GlobalConstants() {
    }
}
