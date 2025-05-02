package com.demo.users.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * UserBase.java
 * <p>
 * Entidad que representa la información básica de un usuario en el sistema.
 * Esta clase es la entidad principal para el almacenamiento de usuarios y mantiene
 * relaciones con otras entidades como {@link UserPhone}.
 * </p>
 *
 * <p>
 * Atributos principales:
 * <ul>
 *   <li>id: Identificador único del usuario (UUID)</li>
 *   <li>name: Nombre del usuario</li>
 *   <li>email: Correo electrónico único del usuario</li>
 *   <li>password: Contraseña del usuario</li>
 *   <li>phones: Lista de teléfonos asociados al usuario</li>
 * </ul>
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Entity
@Table(name = "users_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "last_login", nullable = false)
    private LocalDateTime lastLogin;

    @Column(name = "api_token", unique = true)
    private UUID token;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "modified")
    private LocalDateTime modified;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<UserPhone> phones;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        if(this.created==null) {
            this.created = now;
        }
        this.modified=now;
        /* Setteamos lastLogin al crear el objeto */
        if(this.lastLogin==null) {
            this.lastLogin = now;
        }
        /* Generamos el API token */
        this.token = UUID.randomUUID();
        /* Valor por default para isActive */
        if (this.isActive == null) {
            this.isActive = true;
        }
    }

}
