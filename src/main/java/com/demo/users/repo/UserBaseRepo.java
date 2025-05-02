package com.demo.users.repo;

import com.demo.users.model.UserBase;

import java.util.Optional;
import java.util.UUID;

/**
 * UserBaseRepo.java
 * <p>
 * Interfaz repositorio que extiende de {@link GenericRepo} para gestionar
 * operaciones específicas relacionadas con la entidad {@link UserBase}.
 * Proporciona métodos personalizados para búsqueda y validación de usuarios
 * por correo electrónico.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
public interface UserBaseRepo extends GenericRepo<UserBase, UUID> {

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email el correo electrónico del usuario a buscar
     * @return un {@link Optional} que contiene el {@link UserBase} encontrado, o vacío si no se encuentra
     */
    Optional<UserBase> findByEmail(String email);

    /**
     * Verifica si existe un usuario con el correo electrónico proporcionado.
     *
     * @param email el correo electrónico a verificar
     * @return true si existe un usuario con el correo electrónico, false en caso contrario
     */
    boolean existsByEmail(String email);

}
