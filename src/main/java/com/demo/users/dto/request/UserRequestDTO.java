package com.demo.users.dto.request;

import com.demo.users.dto.constraint.email.DominioCl;
import com.demo.users.dto.constraint.password.ValidPassword;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

/**
 *
 * UserRequestDTO.java
 * <p>
 * DTO (Data Transfer Object) para la creación y actualización de usuarios.
 * Contiene validaciones para los campos:
 * <ul>
 *     <li>name: Nombre del usuario</li>
 *     <li>email: Correo electrónico con dominio .cl</li>
 *     <li>password: Contraseña que cumple con el patrón de seguridad configurado</li>
 *     <li>phones: Lista de teléfonos asociados al usuario</li>
 * </ul>
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre {min} y {max} caracteres")
    private String name;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo no es válido")
    @DominioCl //Se habilita constraint para validar que el email sea del dominio dominio.cl
    private String email;

    @ValidPassword
    private String password;

    @NotEmpty(message = "Al menos un teléfono es requerido")
    private List<UserPhoneRequestDTO> phones;
}
