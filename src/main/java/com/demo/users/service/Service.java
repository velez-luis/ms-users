package com.demo.users.service;

import java.util.List;
/**
 * Service.java
 * <p>
 * Interfaz genérica que define las operaciones CRUD básicas para los servicios.
 * </p>
 *
 * @param <T> el tipo de entidad que maneja el servicio
 * @param <ID> el tipo del identificador de la entidad
 *
 * @author Luis Velez
 * @version 1.0
 */
public interface Service<T, ID> {

    /**
     * Crea una nueva entidad.
     *
     * @param t la entidad a crear
     * @return la entidad creada
     * @throws Exception si ocurre un error durante la creación
     */
     T create(T t) throws Exception;

     /**
     * Actualiza una entidad existente.
     *
     * @param t la entidad con los nuevos datos
     * @param id el identificador de la entidad a actualizar
     * @return la entidad actualizada
     * @throws Exception si ocurre un error durante la actualización
     */
     T update(T t, ID id) throws Exception;

    /**
     * Elimina físicamente una entidad por su identificador.
     *
     * @param id el identificador de la entidad a eliminar
     * @throws Exception si ocurre un error durante la eliminación
    */
    void physicalDelete(ID id) throws Exception;

    /**
     * Recupera todas las entidades.
     *
     * @return lista con todas las entidades
     * @throws Exception si ocurre un error durante la búsqueda
     */
    List<T> findAll() throws Exception;

    /**
     * Recupera una entidad por su identificador.
     *
     * @param id el identificador de la entidad
     * @return la entidad encontrada
     * @throws Exception si ocurre un error durante la búsqueda
     */
    T getById(ID id) throws Exception;

}
