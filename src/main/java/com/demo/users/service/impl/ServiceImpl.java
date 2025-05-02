package com.demo.users.service.impl;

import com.demo.users.exception.ModelNotFoundException;
import com.demo.users.repo.GenericRepo;
import com.demo.users.service.Service;

import java.util.List;
/**
 * ServiceImpl.java
 * <p>
 * Implementación abstracta base de la interfaz {@link Service} que proporciona
 * la funcionalidad CRUD común para todos los servicios. Utiliza un {@link GenericRepo}
 * para realizar las operaciones de persistencia.
 * </p>
 *
 * @param <T> el tipo de entidad que maneja el servicio
 * @param <ID> el tipo del identificador de la entidad
 *
 * @author Luis Velez
 * @version 1.0
 */
public abstract class ServiceImpl<T, ID> implements Service<T, ID> {

    private static final String ID_NOT_FOUND_MESSAGE = "ID NOT FOUND ";

    protected abstract GenericRepo<T, ID> getRepo();

    @Override
    public T create(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException(ID_NOT_FOUND_MESSAGE + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T getById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException(ID_NOT_FOUND_MESSAGE + id));
    }

    @Override
    public void physicalDelete(ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException(ID_NOT_FOUND_MESSAGE + id));
        getRepo().deleteById(id);
    }
}
