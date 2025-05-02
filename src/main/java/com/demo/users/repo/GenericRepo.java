package com.demo.users.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * GenericRepo.java
 * <p>
 * Interfaz repositorio genérica que extiende de JpaRepository para proporcionar
 * operaciones CRUD básicas. Esta interfaz sirve como base para todos los
 * repositorios específicos de la aplicación.
 * </p>
 *
 * @param <T> tipo de la entidad
 * @param <ID> tipo del identificador de la entidad
 *
 * @author Luis Velez
 * @version 1.0
 */
@NoRepositoryBean
public interface GenericRepo<T, ID> extends JpaRepository<T, ID>{
	
}
