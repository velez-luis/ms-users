package com.demo.users.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
/**
 * UserPhone.java
 * <p>
 * Entidad que representa los teléfonos asociados a un usuario en el sistema.
 * Esta clase mantiene una relación muchos a uno con {@link UserBase}.
 * </p>
 *
 * <p>
 * Atributos principales:
 * <ul>
 *   <li>id: Identificador único del teléfono (UUID)</li>
 *   <li>number: Número de teléfono</li>
 *   <li>citycode: Código de la ciudad</li>
 *   <li>countrycode: Código del país</li>
 *   <li>user: Usuario al que pertenece el teléfono</li>
 * </ul>
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Entity
@Table(name = "users_phones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 15)
    private String number;

    @Column(name = "citycode", nullable = false, length = 5)
    private String citycode;

    @Column(name = "countrycode", nullable = false, length = 5)
    private String countrycode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private UserBase user;

}
