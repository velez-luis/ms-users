package com.demo.users.service;

import com.demo.users.dto.response.UserResponseDTO;
import com.demo.users.model.UserBase;

import java.util.UUID;
/**
 * UserBaseService.java
 * <p>
 * Interfaz de servicio que extiende de {@link Service} para gestionar
 * operaciones específicas relacionadas con {@link UserBase}.
 * Proporciona métodos para búsqueda y validación de usuarios por correo electrónico.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
public interface UserBaseService extends Service<UserBase, UUID> {

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email el correo electrónico del usuario a buscar
     * @return el {@link UserBase} encontrado, o null si no se encuentra
     */
    UserResponseDTO findByEmail(String email);

}
